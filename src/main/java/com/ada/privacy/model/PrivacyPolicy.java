package com.ada.privacy.model;


import jakarta.persistence.*;

@Entity
@Table
public class PrivacyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String website;
    private String letterGrade;
    private String gradeSummary;
    private String aboutDataCollection;
    private String aboutDataStorage;
    private String aboutUserRights;
    private String aboutDataSecurity;

    public PrivacyPolicy() {

    }

    public PrivacyPolicy(String website, String letterGrade, String gradeSummary, String aboutDataCollection, String aboutDataStorage, String aboutUserRights, String aboutDataSecurity) {
        this.website = website;
        this.letterGrade = letterGrade;
        this.gradeSummary = gradeSummary;
        this.aboutDataCollection = aboutDataCollection;
        this.aboutDataStorage = aboutDataStorage;
        this.aboutUserRights = aboutUserRights;
        this.aboutDataSecurity = aboutDataSecurity;
    }

//    Getters
    public Long getId() {
        return id;
    }

    public String getWebsite() {
        return website;
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

//    Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    @Override
    public String toString() {
        return "PrivacyPolicy{" +
                "id=" + id +
                ", letterGrade='" + letterGrade + '\'' +
                ", gradeSummary='" + gradeSummary + '\'' +
                ", aboutDataCollection='" + aboutDataCollection + '\'' +
                ", aboutDataStorage='" + aboutDataStorage + '\'' +
                ", aboutUserRights='" + aboutUserRights + '\'' +
                ", aboutDataSecurity='" + aboutDataSecurity + '\'' +
                '}';
    }
}
