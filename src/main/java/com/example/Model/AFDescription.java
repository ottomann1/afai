package com.example.Model;


public class AFDescription {

    private Long id;

    private String text;
    private String text_formatted;
    private String company_information;
    private String needs;
    private String requirements;
    private String conditions;


    public AFDescription() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText_formatted() {
        return text_formatted;
    }

    public void setText_formatted(String text_formatted) {
        this.text_formatted = text_formatted;
    }

    public String getCompany_information() {
        return company_information;
    }

    public void setCompany_information(String company_information) {
        this.company_information = company_information;
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
