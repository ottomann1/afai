package com.example.Model;

import jakarta.persistence.*;

@Entity
public class SmallPromptObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String headline;
    private String occupation;
    private String applicationDeadline;
    private String label;
    private String employer;
    private String workplace;
    private String addressRegion;
    private String addressStreetAddress;
    private String addressPostcode;
    private String description;
    private String publicationDate;
    private String detectedLanguage;
    private String aiIndustry;
    private String aiJobRole;
    private String aiTechnology;
    private String aiMerits;
    private String aiOther;
    private String aiLocations;

    public String getAiIndustry() {
        return aiIndustry;
    }

    public void setAiIndustry(String aiIndustry) {
        this.aiIndustry = aiIndustry;
    }

    public String getAiJobRole() {
        return aiJobRole;
    }

    public void setAiJobRole(String aiJobRole) {
        this.aiJobRole = aiJobRole;
    }

    public String getAiTechnology() {
        return aiTechnology;
    }

    public void setAiTechnology(String aiTechnology) {
        this.aiTechnology = aiTechnology;
    }

    public String getAiMerits() {
        return aiMerits;
    }

    public void setAiMerits(String aiMerits) {
        this.aiMerits = aiMerits;
    }

    public String getAiOther() {
        return aiOther;
    }

    public void setAiOther(String aiOther) {
        this.aiOther = aiOther;
    }

    public String getAiLocations() {
        return aiLocations;
    }

    public void setAiLocations(String aiLocations) {
        this.aiLocations = aiLocations;
    }

    public String getDetectedLanguage() {
        return detectedLanguage;
    }

    public void setDetectedLanguage(String detectedLanguage) {
        this.detectedLanguage = detectedLanguage;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(String applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SmallPromptObject() {
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getAddressRegion() {
        return addressRegion;
    }

    public void setAddressRegion(String addressRegion) {
        this.addressRegion = addressRegion;
    }

    public String getAddressStreetAddress() {
        return addressStreetAddress;
    }

    public void setAddressStreetAddress(String addressStreetAddress) {
        this.addressStreetAddress = addressStreetAddress;
    }

    public String getAddressPostcode() {
        return addressPostcode;
    }

    public void setAddressPostcode(String addressPostcode) {
        this.addressPostcode = addressPostcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}
