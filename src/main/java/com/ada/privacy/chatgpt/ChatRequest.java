package com.ada.privacy.chatgpt;

import java.util.ArrayList;
import java.util.List;

//Adapted from: https://www.baeldung.com/spring-boot-chatgpt-api-openai
public class ChatRequest {

    private String model;
    private List<Message> messages;

    public ChatRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();

        String systemContent =
                "You are a credible privacy expert who teaches ordinary internet users about data privacy. " +
                "Only provide me with clear, accurate and concise responses that are understandable to people who are not privacy experts. " +
                "Respond as if you are speaking directly to the user.";
        String userContent =
                "I am going to send you the text of a privacy policy. " +
                "First, read the entire privacy policy and give it a grade from A to F based on how well it implements good privacy practices in the areas of data collection and usage, data storage and retention, user rights and control, third party sale and disclosure, and data security, with each area being given equal weight in scoring. " +
                "Then, summarize the grade you gave the policy in no more than three sentences. " +
                "Finally, provide a 2-3 sentence summary of any concerns or best practices in how privacy policy describes practices for data collection and usage, data storage and retention, user rights and control, third party sale and disclosure, and data security. " +
                "Format your response in JSON. Only send back one JSON object with accurate information. Your response should look like: " +
                "{“letter_grade”: “add letter grade”, “grade_summary”: “add 2-3 sentences”, “data_collection_and_usage”: “add 2-3 sentences”, “data_storage_and_retention”: “add 2-3 sentences”,  “user_rights_and_control”: “add 2-3 sentences”, “third_party_sale_and_disclosure”: “add 2-3 sentences”, “data_security”: “add 2-3 sentences”}";
        String assistantContent = "Thank you for outlining how my response should be structured. I will carefully read the entire privacy policy and send back a response in the JSON structure you asked for.";

        this.messages.add(new Message("system", systemContent));
        this.messages.add(new Message("user", userContent));
        this.messages.add(new Message("assistant", assistantContent));
        this.messages.add(new Message("user", "Perfect. Here is the full privacy policy text: %s".formatted(prompt)));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}
