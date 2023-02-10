package com.example.Repository;

import com.example.Model.Afcsv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AfcsvRepo extends JpaRepository<Afcsv, Integer> {
}
