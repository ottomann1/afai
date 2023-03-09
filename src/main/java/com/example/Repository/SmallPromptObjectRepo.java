package com.example.Repository;

import com.example.Model.SmallPromptObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmallPromptObjectRepo extends JpaRepository<SmallPromptObject, Integer> {
    Iterable<SmallPromptObject> findByAiIndustryNotNull();
}
