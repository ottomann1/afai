package com.example;

import com.example.Model.Afcsv;
import com.example.Model.OpenAIPrompt;
import com.example.Model.SmallPromptObject;
import com.example.Service.AfcsvService;
import com.example.Service.OpenAIPromptService;
import com.example.Service.SmallPromptObjectService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

@SpringBootApplication
public class DatabaseApplication {
    @Autowired
    private AfcsvService afservice;

    @Autowired
    private OpenAIPromptService openAIPromptService;

    @Autowired
    private SmallPromptObjectService spoService;

    public static void main(String[] args) throws IOException {
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

    //TODO: Hämta annonser bara från de företag som Saad skickade på linkedin

    //TODO: Rensa annonserna för att bara inkludera viktiga saker
    @PostConstruct
    private void postInit() throws IOException {
        afcsvToSpo();
//        loadfiles();
//        extractByCompany();
//        spoService.newlineRemover();
//        updateAiSpo();
//        spoToPrompt();
//        openAIPromptService.writeAllToFile();
    }

    private void extractByCompany() {
        String[] employers = {"SEB %",
                "%Swedbank AB%",
                "AMF%",
                "%Handelsbanken%",
                "IF",
                "Länsförsäkringar%",
                "Folksam%",
                "%Movestic%",
                "%SPP%",
                "%Nordnet%",
                "%Avanza%",
                "%Antisimex%",
                "%Nordea%",
                "%Betsson%",
                "%SBAB%",
                "%Skandia%",
                "ICA%",
                "SJ %",
                "%Scania%",
                "%SOS Alarm%",
                "%Moderna försäkringar%",
                "%Anticimex%",
                "%Kindred%",
                "%Klarna%",
                "%Bliwa%",
                "HM %",
                "%LeoVegas%",
                "%Svea bank%",
                "AFA%",
                "%Spotify%",
                "%Söderberg & partners%",
                "%Billogram%",
                "%Quinyx%"};

        Collection<Afcsv> afcsvList = new ArrayList<Afcsv>();
        for (String employer :
                employers) {
            afcsvList.addAll(afservice.getByCompany(employer));
        }
        for (Afcsv afcsv : afcsvList) {
            spoService.save(spoService.afcsvToSmallPromptObject(afcsv));
        }
    }

    private void afcsvToSpo(){
            afservice.streamAllToSpo();

    }

    private void loadfiles() throws IOException {
        String[] paths = {
                "C:\\Users\\ottok\\Downloads\\afjson\\2006",
                "C:\\Users\\ottok\\Downloads\\afjson\\2007",
                "C:\\Users\\ottok\\Downloads\\afjson\\2008",
                "C:\\Users\\ottok\\Downloads\\afjson\\2009",
                "C:\\Users\\ottok\\Downloads\\afjson\\2010",
                "C:\\Users\\ottok\\Downloads\\afjson\\2011",
                "C:\\Users\\ottok\\Downloads\\afjson\\2012",
                "C:\\Users\\ottok\\Downloads\\afjson\\2013",
                "C:\\Users\\ottok\\Downloads\\afjson\\2014",
                "C:\\Users\\ottok\\Downloads\\afjson\\2015",
                "C:\\Users\\ottok\\Downloads\\afjson\\2016",
                "C:\\Users\\ottok\\Downloads\\afjson\\2017",
                "C:\\Users\\ottok\\Downloads\\afjson\\2018",
                "C:\\Users\\ottok\\Downloads\\afjson\\2019",
                "C:\\Users\\ottok\\Downloads\\afjson\\2020",
                "C:\\Users\\ottok\\Downloads\\afjson\\2021",
                "C:\\Users\\ottok\\Downloads\\afjson\\2022"};
        for (String path :
                paths) {
            System.out.println(path);
            afservice.readAfcsvFromFile(path + ".json");
        }
    }

    private void updateAiSpo() throws IOException {
        InputStream input = new FileInputStream("C:\\reporoot\\aiais.txt");
        Scanner scan = new Scanner(input);
        while (scan.hasNextLine()) {
            SmallPromptObject spo = spoService.get(Long.valueOf(scan.nextLine().replace("ID:", "")));
            spo.setAiIndustry(scan.nextLine().replace("Industry: ", ""));
            spo.setAiJobRole(scan.nextLine().replace("Job role: ", ""));
            spo.setAiTechnology(scan.nextLine().replace("Technology: ", ""));
            spo.setAiMerits(scan.nextLine().replace("Merits: ", ""));
            spo.setAiOther(scan.nextLine().replace("Other: ", ""));
            spo.setAiLocations(scan.nextLine().replace("Locations: ", ""));
            spoService.update(spo);
        }
    }

    private void spoToPrompt() {
        List<SmallPromptObject> spos = spoService.getAllAiSpo();
        for (SmallPromptObject spo :
                spos) {
            OpenAIPrompt openAIPrompt = new OpenAIPrompt();
            openAIPrompt.setId(spo.getId());
            openAIPrompt.setPrompt(spo.getDescription());
            openAIPrompt.setCompletion(
//                    "Industry: " + spo.getAiIndustry() +
//                            ". Job role: " + spo.getAiJobRole() +
                            spo.getAiTechnology() +
//                            ". Merits: " + spo.getAiMerits() +
//                            ". Other: " + spo.getAiOther() +
//                            ". Locations: " + spo.getAiLocations() +
                            ".");
            openAIPromptService.save(openAIPrompt);
        }
    }
}
