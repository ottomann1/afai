package com.example.Service;


import com.example.Model.Afcsv;
import com.example.Model.OpenAIPrompt;
import com.example.Repository.OpenAIPromptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        openAIPrompt.setPrompt(afcsv.getHeadline() + "\n\n" + afcsv.getDescription() + "\n\n" + afcsv.getPublicationDate());
        openAIPrompt.setCompletion(afcsv.getEmployer());
        return save(openAIPrompt);
    }

    private void companyFormat(Afcsv afcsv) {
        String tempString = afcsv.getHeadline();
        String tempCompanyName = afcsv.getEmployer();
        tempCompanyName.replace(" AB", "");
        tempString = afcsv.getDescription();
        afcsv.setDescription(tempString.replace(tempCompanyName, ""));
        afcsv.setHeadline(tempString.replace(afcsv.getEmployer(), ""));
    }
}
