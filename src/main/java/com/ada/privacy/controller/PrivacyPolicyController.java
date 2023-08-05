package com.ada.privacy.controller;

import com.ada.privacy.model.PrivacyPolicy;
import com.ada.privacy.request.IncomingText;
import com.ada.privacy.service.PrivacyPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/summaries")
public class PrivacyPolicyController {

    @Autowired
    private PrivacyPolicyService privacyPolicyService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PrivacyPolicy getPrivacyPolicy(@RequestBody IncomingText incomingText) {
        return this.privacyPolicyService.getSummary(incomingText);
    }
    
}
