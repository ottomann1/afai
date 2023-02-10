package com.example.Repository;

import com.example.Model.OpenAIPrompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenAIPromptRepo extends JpaRepository<OpenAIPrompt, Integer> {
}
