package com.example.Model;

import jakarta.persistence.*;

@Entity
public class OpenAIPrompt {
    @Id
    private Long id;

    private String prompt;
    private String completion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OpenAIPrompt() {
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion;
    }

    public String getJsonlObject(){
        return "{\"prompt\": \""+prompt+"\", \"completion\": \""+completion+"\"}";
    }
}
