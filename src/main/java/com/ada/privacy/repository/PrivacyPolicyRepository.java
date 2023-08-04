package com.ada.privacy.repository;

import com.ada.privacy.model.PrivacyPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrivacyPolicyRepository extends JpaRepository<PrivacyPolicy, Long> {
    @Query(value = "select p from PrivacyPolicy p where p.website=?1")
    PrivacyPolicy findByWebsite(String website);
}
