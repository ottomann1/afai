package com.example.Repository;

import com.example.Model.Afcsv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AfcsvRepo extends JpaRepository<Afcsv, Integer> {
    @Query("select p from Afcsv p where p.employer like ?1")
    List<Afcsv> findAllByEmployer(String employer);
}
