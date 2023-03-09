package com.example.Controller;

import com.example.Model.SmallPromptObject;
import com.example.Service.SmallPromptObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/spo")
public class SmallPromptObjectController {
    private final SmallPromptObjectService service;

    @Autowired
    public SmallPromptObjectController(SmallPromptObjectService service) {
        this.service = service;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        try {
            System.out.println("Sending spo with id " + id);
            SmallPromptObject spo = service.get(id);
            return new ResponseEntity<>(spo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
