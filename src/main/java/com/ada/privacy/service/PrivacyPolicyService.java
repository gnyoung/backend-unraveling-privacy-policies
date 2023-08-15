package com.ada.privacy.service;

import com.ada.privacy.chatgpt.ChatRequest;
import com.ada.privacy.chatgpt.ChatResponse;
import com.ada.privacy.model.PrivacyPolicy;
import com.ada.privacy.repository.PrivacyPolicyRepository;
import com.ada.privacy.request.IncomingText;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PrivacyPolicyService {

    private final PrivacyPolicyRepository privacyPolicyRepository;

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Autowired
    public PrivacyPolicyService(PrivacyPolicyRepository privacyPolicyRepository) {
        this.privacyPolicyRepository = privacyPolicyRepository;
    }

    public JsonObject convertResponseToJson(String response) {
       JsonObject responseObj = new Gson().fromJson(response, JsonObject.class);

        return responseObj;
    }

    public PrivacyPolicy getSummary(IncomingText incomingText) {
        String incomingSite = incomingText.getWebsite();
        PrivacyPolicy isStoredSite = this.privacyPolicyRepository.findByWebsite(incomingSite);
        if (isStoredSite != null) {
            return isStoredSite;
        }

        String prompt = incomingText.getText();

        //Adapted from: https://www.baeldung.com/spring-boot-chatgpt-api-openai
        ChatRequest request = new ChatRequest(model, prompt);
        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);
        if (response == null) {
            return null;
        }

        String responseData = response.getChoices().get(0).getMessage().getContent();

        JsonObject responseObj = convertResponseToJson(responseData);

        String letterGrade = responseObj.get("letter_grade").getAsString();
        String gradeSummary = responseObj.get("grade_summary").getAsString();
        String dataCollectionAndUsage = responseObj.get("data_collection_and_usage").getAsString();
        String dataStorageAndRetention = responseObj.get("data_storage_and_retention").getAsString();
        String userRightsAndControl = responseObj.get("user_rights_and_control").getAsString();
        String thirdPartySaleAndDisclosure = responseObj.get("third_party_sale_and_disclosure").getAsString();
        String dataSecurity = responseObj.get("data_security").getAsString();


        PrivacyPolicy summary = new PrivacyPolicy(incomingSite,
                letterGrade, gradeSummary, dataCollectionAndUsage,
                dataStorageAndRetention, userRightsAndControl, thirdPartySaleAndDisclosure, dataSecurity);

        privacyPolicyRepository.save(summary);

        return summary;
    }
}