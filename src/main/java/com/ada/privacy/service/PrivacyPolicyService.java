package com.ada.privacy.service;

import com.ada.privacy.model.PrivacyPolicy;
import com.ada.privacy.repository.PrivacyPolicyRepository;
import com.ada.privacy.request.IncomingText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivacyPolicyService {

    private final PrivacyPolicyRepository privacyPolicyRepository;

    @Autowired
    public PrivacyPolicyService(PrivacyPolicyRepository privacyPolicyRepository) {
        this.privacyPolicyRepository = privacyPolicyRepository;
    }

    public PrivacyPolicy getSummary(IncomingText incomingText) {
        String incomingSite = incomingText.getWebsite();
        PrivacyPolicy isStoredSite = this.privacyPolicyRepository.findByWebsite(incomingSite);
        if (isStoredSite != null) {
            return isStoredSite;
        }
        return isStoredSite;
    }
}