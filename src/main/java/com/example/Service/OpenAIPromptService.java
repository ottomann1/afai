package com.example.Service;


import com.example.Model.Afcsv;
import com.example.Model.OpenAIPrompt;
import com.example.Model.SmallPromptObject;
import com.example.Repository.OpenAIPromptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

@Service
public class OpenAIPromptService {
    private final OpenAIPromptRepo repository;

    @Autowired
    public OpenAIPromptService(OpenAIPromptRepo repository) {
        this.repository = repository;
    }

    public OpenAIPrompt getItem(Integer id){
        return repository.findById(id).get();
    }

    public OpenAIPrompt save(OpenAIPrompt openAIPrompt){
        return repository.save(openAIPrompt);
    }

    public OpenAIPrompt createPrompt(Afcsv afcsv){
        OpenAIPrompt openAIPrompt = new OpenAIPrompt();
        companyFormat(afcsv);
        openAIPrompt.setPrompt("Headline: "+ afcsv.getHeadline() + "\nDescription: " + afcsv.getDescription() + "\nPublication date: " + afcsv.getPublicationDate()+ "\nAddress: "+ afcsv.getWorkplaceAddress()+", "+afcsv.getDetectedLanguage()+", "+afcsv.getApplicationContacts());
        openAIPrompt.setPrompt(openAIPrompt.getPrompt().replace("\"", "'"));
        openAIPrompt.setCompletion(afcsv.getEmployer());
        return save(openAIPrompt);
    }

    public OpenAIPrompt createPrompt(SmallPromptObject spo){
        OpenAIPrompt openAIPrompt = new OpenAIPrompt();
        companyFormat(spo);
        openAIPrompt.setPrompt("Headline: "+ spo.getHeadline() + "\nDescription: " + spo.getDescription() + "\nPublication date: " + spo.getPublicationDate()+ "\nAddress: "+ spo.getAddressStreetAddress()+", "+spo.getAddressPostcode()+", "+spo.getAddressRegion());
        openAIPrompt.setPrompt(openAIPrompt.getPrompt().replace("\"", "'"));
        openAIPrompt.setCompletion(spo.getEmployer());
        return save(openAIPrompt);
    }

    private void companyFormat(Afcsv afcsv) {
        String tempCompanyName = afcsv.getEmployer();
        tempCompanyName.replace(" AB", "");
        String tempString = afcsv.getDescription();
        afcsv.setDescription(tempString.replace(tempCompanyName, "").replace("\n", " ").replace("\r", ""));
        afcsv.setHeadline(tempString.replace(afcsv.getEmployer(), ""));
    }

    private void companyFormat(SmallPromptObject spo) {
        String tempCompanyName = spo.getEmployer();
        tempCompanyName.replace(" AB", "");
        String tempString = spo.getDescription();
        spo.setDescription(tempString.replace(tempCompanyName, "").replace("\n", " ").replace("\r", ""));
        spo.setHeadline(tempString.replace(spo.getEmployer(), ""));
    }

    public void writeToFile(OpenAIPrompt openAIPrompt){
        try{
            FileWriter writer = new FileWriter("prompt.jsonl");
            writer.write(openAIPrompt.getPrompt());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeAllToFile(){
        try{
            FileWriter writer = new FileWriter("techprompt.jsonl");
            Stream<OpenAIPrompt> promptStream = repository.findAll().stream();
            promptStream.forEach((prompt) ->{
                try {
                    String newPrompt = prompt.getJsonlObject();
                    newPrompt = newPrompt.replace("\n", "\\n").replace("\r", "\\r");
                    writer.write(newPrompt.concat("\n"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
