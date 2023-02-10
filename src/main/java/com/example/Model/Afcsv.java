package com.example.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import org.springframework.beans.factory.annotation.Autowired;


@Entity
public class Afcsv {

    @Column(name = "access", nullable = true, length = -1)
    private String access;

    @Column(name = "access_to_own_car", nullable = true, length = -1)
    private String accessToOwnCar;

    @Column(name = "application_deadline", nullable = true, length = -1)
    private String applicationDeadline;

    @Column(name = "application_details", nullable = true, length = -1)
    private String applicationDetails;

    @Lob
    @Column(name = "description", unique = true)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "driving_license", nullable = true, length = -1)
    private String drivingLicense;

    @Column(name = "driving_license_required", nullable = true, length = -1)
    private String drivingLicenseRequired;

    @Column(name = "duration", nullable = true, length = -1)
    private String duration;

    @Column(name = "employer", nullable = true, length = -1)
    private String employer;

    @Column(name = "employment_type", nullable = true, length = -1)
    private String employmentType;

    @Column(name = "experience_required", nullable = true, length = -1)
    private String experienceRequired;

    @Column(name = "external_id", nullable = true, length = -1)
    private String externalId;

    @Column(name = "franchise", nullable = true, length = -1)
    private String franchise;

    @Column(name = "hash", nullable = true, length = -1)
    private String hash;

    @Column(name = "headline", nullable = true, length = -1)
    private String headline;

    @Column(name = "hire_work_place", nullable = true, length = -1)
    private String hireWorkPlace;

    @Id
    @Column(name = "id", nullable = true)
    private Integer id;

    @Column(name = "keywords", nullable = true, length = -1)
    private String keywords;

    @Column(name = "larling", nullable = true, length = -1)
    private String larling;

    @Column(name = "last_publication_date", nullable = true, length = -1)
    private String lastPublicationDate;

    @Column(name = "logo_url", nullable = true, length = -1)
    private String logoUrl;

    @Column(name = "must_have", nullable = true, length = -1)
    private String mustHave;

    @Column(name = "nice_to_have", nullable = true, length = -1)
    private String niceToHave;

    @Column(name = "number_of_vacancies", nullable = true)
    private Integer numberOfVacancies;

    @Column(name = "occupation", nullable = true, length = -1)
    private String occupation;

    @Column(name = "occupation_field", nullable = true, length = -1)
    private String occupationField;

    @Column(name = "occupation_group", nullable = true, length = -1)
    private String occupationGroup;

    @Column(name = "open_for_all", nullable = true, length = -1)
    private String openForAll;

    @Column(name = "publication_date", nullable = true, length = -1)
    private String publicationDate;

    @Column(name = "remote_work", nullable = true, length = -1)
    private String remoteWork;

    @Column(name = "removed", nullable = true, length = -1)
    private String removed;

    @Column(name = "removed_date", nullable = true, length = -1)
    private String removedDate;

    @Column(name = "salary_description", nullable = true, length = -1)
    private String salaryDescription;

    @Column(name = "salary_type", nullable = true, length = -1)
    private String salaryType;

    @Column(name = "scope_of_work", nullable = true, length = -1)
    private String scopeOfWork;

    @Column(name = "source_type", nullable = true, length = -1)
    private String sourceType;

    @Column(name = "timestamp", nullable = true, length = -1)
    private String timestamp;

    @Column(name = "trainee", nullable = true, length = -1)
    private String trainee;

    @Column(name = "uuid", nullable = true, length = -1)
    private String uuid;

    @Column(name = "webpage_url", nullable = true, length = -1)
    private String webpageUrl;

    @Column(name = "working_hours_type", nullable = true, length = -1)
    private String workingHoursType;

    @Column(name = "workplace_address", nullable = true, length = -1)
    private String workplaceAddress;

    @Column(name = "detected_language", nullable = true, length = -1)
    private String detectedLanguage;

    @Column(name = "application_contacts", nullable = true, length = -1)
    private String applicationContacts;

    public Afcsv() {
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getAccessToOwnCar() {
        return accessToOwnCar;
    }

    public void setAccessToOwnCar(String accessToOwnCar) {
        this.accessToOwnCar = accessToOwnCar;
    }

    public String getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(String applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    public String getApplicationDetails() {
        return applicationDetails;
    }

    public void setApplicationDetails(String applicationDetails) {
        this.applicationDetails = applicationDetails;
    }


    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getDrivingLicenseRequired() {
        return drivingLicenseRequired;
    }

    public void setDrivingLicenseRequired(String drivingLicenseRequired) {
        this.drivingLicenseRequired = drivingLicenseRequired;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(String experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getHireWorkPlace() {
        return hireWorkPlace;
    }

    public void setHireWorkPlace(String hireWorkPlace) {
        this.hireWorkPlace = hireWorkPlace;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLarling() {
        return larling;
    }

    public void setLarling(String larling) {
        this.larling = larling;
    }

    public String getLastPublicationDate() {
        return lastPublicationDate;
    }

    public void setLastPublicationDate(String lastPublicationDate) {
        this.lastPublicationDate = lastPublicationDate;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getMustHave() {
        return mustHave;
    }

    public void setMustHave(String mustHave) {
        this.mustHave = mustHave;
    }

    public String getNiceToHave() {
        return niceToHave;
    }

    public void setNiceToHave(String niceToHave) {
        this.niceToHave = niceToHave;
    }

    public Integer getNumberOfVacancies() {
        return numberOfVacancies;
    }

    public void setNumberOfVacancies(Integer numberOfVacancies) {
        this.numberOfVacancies = numberOfVacancies;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupationField() {
        return occupationField;
    }

    public void setOccupationField(String occupationField) {
        this.occupationField = occupationField;
    }

    public String getOccupationGroup() {
        return occupationGroup;
    }

    public void setOccupationGroup(String occupationGroup) {
        this.occupationGroup = occupationGroup;
    }

    public String getOpenForAll() {
        return openForAll;
    }

    public void setOpenForAll(String openForAll) {
        this.openForAll = openForAll;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getRemoteWork() {
        return remoteWork;
    }

    public void setRemoteWork(String remoteWork) {
        this.remoteWork = remoteWork;
    }

    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed;
    }

    public String getRemovedDate() {
        return removedDate;
    }

    public void setRemovedDate(String removedDate) {
        this.removedDate = removedDate;
    }

    public String getSalaryDescription() {
        return salaryDescription;
    }

    public void setSalaryDescription(String salaryDescription) {
        this.salaryDescription = salaryDescription;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public String getScopeOfWork() {
        return scopeOfWork;
    }

    public void setScopeOfWork(String scopeOfWork) {
        this.scopeOfWork = scopeOfWork;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTrainee() {
        return trainee;
    }

    public void setTrainee(String trainee) {
        this.trainee = trainee;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getWebpageUrl() {
        return webpageUrl;
    }

    public void setWebpageUrl(String webpageUrl) {
        this.webpageUrl = webpageUrl;
    }

    public String getWorkingHoursType() {
        return workingHoursType;
    }

    public void setWorkingHoursType(String workingHoursType) {
        this.workingHoursType = workingHoursType;
    }

    public String getWorkplaceAddress() {
        return workplaceAddress;
    }

    public void setWorkplaceAddress(String workplaceAddress) {
        this.workplaceAddress = workplaceAddress;
    }

    public String getDetectedLanguage() {
        return detectedLanguage;
    }

    public void setDetectedLanguage(String detectedLanguage) {
        this.detectedLanguage = detectedLanguage;
    }

    public String getApplicationContacts() {
        return applicationContacts;
    }

    public void setApplicationContacts(String applicationContacts) {
        this.applicationContacts = applicationContacts;
    }

}
