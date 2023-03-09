package com.example.Service;

import com.example.Model.Afcsv;
import com.example.Model.OpenAIPrompt;
import com.example.Model.SmallPromptObject;
import com.example.Repository.OpenAIPromptRepo;
import com.example.Repository.SmallPromptObjectRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Service
public class SmallPromptObjectService {
    private final SmallPromptObjectRepo repository;

    //Denna klass ska användas för att ha en mer utvald och uppdaterbar lista med objekt istället för afcsv
    //som är som en större databas för alla objekt inom Data/IT
    //Den här ska innehålla bara de företag från en viss lista och snart ska även deras description göras
    //om till att innehålla bara det viktiga.
    @Autowired
    public SmallPromptObjectService(SmallPromptObjectRepo repository) {
        this.repository = repository;
    }

    public Collection<SmallPromptObject> getAll(){
        return this.repository.findAll();
    }

    public List<SmallPromptObject> getAllAiSpo(){
        return (List<SmallPromptObject>) this.repository.findByAiIndustryNotNull();
    }

    public SmallPromptObject afcsvToSmallPromptObject(Afcsv afcsv){
        SmallPromptObject spo = new SmallPromptObject();
        spo.setDescription(afcsv.getDescription());
        spo.setEmployer(afcsv.getEmployer());
        spo.setOccupation(afcsv.getOccupation());
        spo.setDetectedLanguage(afcsv.getDetectedLanguage());
        spo.setApplicationDeadline(afcsv.getApplicationDeadline());
        spo.setAddressPostcode(afcsv.getWorkingHoursType());
        spo.setAddressRegion(afcsv.getApplicationContacts());
        spo.setAddressStreetAddress(afcsv.getWorkplaceAddress());
        spo.setHeadline(afcsv.getHeadline());
        spo.setId(afcsv.getId());
        spo.setLabel(afcsv.getOccupationField());
        spo.setPublicationDate(afcsv.getPublicationDate());
        return spo;
    }

    public SmallPromptObject save(SmallPromptObject spo){
        return this.repository.save(spo);
    }

    public SmallPromptObject get(Long id){
        return this.repository.findById(id.intValue()).get();
    }

    public SmallPromptObject update(SmallPromptObject spo){
        return this.repository.saveAndFlush(spo);
    }

    public void newlineRemover(){
        List<SmallPromptObject> promptStream = repository.findAll();
        promptStream.forEach((prompt) ->{
            prompt.setDescription(prompt.getDescription().replace("\n", " ").replace("\r", "").replace("\"", "'"));
            save(prompt);
        });
    }

    public void writeAllToFile(){
        try{
            FileWriter writer = new FileWriter("allSpo.json");
            Gson gson = new Gson();
            List<SmallPromptObject> promptStream = repository.findAll();
            promptStream.forEach((prompt) ->{
                prompt.setDescription(prompt.getDescription().replace("\n", " ").replace("\r", ""));
            });
            try {

                writer.write(gson.toJson(promptStream));
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
