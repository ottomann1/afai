package com.example;

import com.example.Model.Afcsv;
import com.example.Service.AfcsvService;
import com.example.Service.OpenAIPromptService;
import com.google.gson.stream.JsonReader;
import com.opencsv.exceptions.CsvException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class DatabaseApplication {
    @Autowired
    private AfcsvService afservice;

    @Autowired
    private OpenAIPromptService openAIPromptService;

    public static void main(String[] args) throws IOException, CsvException {
        SpringApplication.run(DatabaseApplication.class, args);

    }
    //TODO: skriv kod som gör en prompt och sparar prompten+svaret från openai i form av följande:
    //Från "Use any information you can find and make a guess as to specifically which organization ordered this ad: +'\n\n'+<afcsv.headline> +'\n\n'+ <afcsv.description>
    //Till "{"prompt": "<prompt text>", "completion": "<ideal generated text>"}

    //TODO: ta reda på hur jag ska göra om annonserna till att inte ha företagsnamn med:

    //fråga lefteris om nosql och tips om hur man använder stora csv eller json filer
    //jq linux json parse
    //använd map json convert json string to hashmap - gson
    //börja med mindre objekt sen fortsätt till dom större
    @PostConstruct
    private void postInit() throws IOException {
//        afservice.readAfcsvFromFile();
            Collection<Afcsv> afcsvList = afservice.getXAmount(5);
        System.out.println(afcsvList.stream().findFirst().get().getDescription());
        for(Afcsv afcsv : afcsvList){
            openAIPromptService.createPrompt(afcsv);
        }
    }
}
