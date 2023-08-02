package com.ada.privacy.model;


import jakarta.persistence.*;

@Entity
@Table
public class PrivacyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String letterGrade;
    private String gradeSummary;
    private String aboutDataCollection;
    private String aboutDataStorage;
    private String aboutUserRights;
    private String aboutDataSecurity;

    public PrivacyPolicy() {

    }

    public PrivacyPolicy(String letterGrade, String gradeSummary, String aboutDataCollection, String aboutDataStorage, String aboutUserRights, String aboutDataSecurity) {
        this.letterGrade = letterGrade;
        this.gradeSummary = gradeSummary;
        this.aboutDataCollection = aboutDataCollection;
        this.aboutDataStorage = aboutDataStorage;
        this.aboutUserRights = aboutUserRights;
        this.aboutDataSecurity = aboutDataSecurity;
    }

    public Long getId() {
        return id;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public String getGradeSummary() {
        return gradeSummary;
    }

    public String getAboutDataCollection() {
        return aboutDataCollection;
    }

    public String getAboutDataStorage() {
        return aboutDataStorage;
    }

    public String getAboutUserRights() {
        return aboutUserRights;
    }

    public String getAboutDataSecurity() {
        return aboutDataSecurity;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public void setGradeSummary(String gradeSummary) {
        this.gradeSummary = gradeSummary;
    }

    public void setAboutDataCollection(String aboutDataCollection) {
        this.aboutDataCollection = aboutDataCollection;
    }

    public void setAboutDataStorage(String aboutDataStorage) {
        this.aboutDataStorage = aboutDataStorage;
    }

    public void setAboutUserRights(String aboutUserRights) {
        this.aboutUserRights = aboutUserRights;
    }

    public void setAboutDataSecurity(String aboutDataSecurity) {
        this.aboutDataSecurity = aboutDataSecurity;
    }
}
