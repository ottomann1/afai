package com.example.Service;

import com.example.Model.Afcsv;
import com.example.Repository.AfcsvRepo;
import com.google.gson.stream.JsonReader;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AfcsvService {
    private final AfcsvRepo repository;

    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    public AfcsvService(AfcsvRepo repository) {
        this.repository = repository;
    }

    public Afcsv getItem(Integer id) {
        return repository.findById(id).get();
    }

    public Collection<Afcsv> getXAmount(int xAmount) {
        Pageable limit = PageRequest.of(140, xAmount);
        return repository.findAll(limit).get().collect(Collectors.toList());

    }

    public Collection<Afcsv> getByCompany(String employer) {
        return repository.findAllByEmployer(employer);
    }

    public Afcsv save(Afcsv afcsv) {
        return repository.save(afcsv);
    }

    public void readAfcsvFromFile(String path) throws IOException {
        InputStream input = new FileInputStream(path);
        JsonReader reader = new JsonReader(new InputStreamReader(input));
        reader.setLenient(true);
        reader.beginArray();
        while (reader.hasNext()) {
            reader.beginObject();
            Afcsv afcsv = new Afcsv();
            boolean willSave = false;
            while (reader.hasNext()) {

                String name = reader.nextName();
//                if (name.equals("id")) {
//                    afcsv.setId(reader.nextString());
//                }
//                else if(name.equals("external_id")){
//                    System.out.println(reader.nextString());
//                }
//                else if (name.equals("webpage_url")) {
//                    afcsv.setWebpageUrl(reader.nextString());
//                }
                if (name.equals("headline")) {
                    try {
                        afcsv.setHeadline(reader.nextString());
                    } catch (IllegalStateException e) {
                        reader.skipValue();
                    }
                } else if (name.equals("application_deadline")) {
                    try {
                        afcsv.setApplicationDeadline(reader.nextString());
                    } catch (IllegalStateException e) {
                        reader.skipValue();
                    }
                } else if (name.equals("occupation")) {
                    reader.beginObject();
                    while (reader.hasNext()) {
                        name = reader.nextName();
                        if (name.equals("label")) {
                            try {
                                String label = reader.nextString();
                                afcsv.setOccupation(label);
                            } catch (IllegalStateException e) {
                                reader.skipValue();
                            }
                        } else
                            reader.skipValue();
                    }
                    reader.endObject();
                }
                else if (name.equals("detected_language")){
                    try{
                        afcsv.setDetectedLanguage(reader.nextString());
                    } catch(IllegalStateException e){
                        reader.skipValue();
                    }
                }
                else if (name.equals("occupation_field")) {
                    reader.beginObject();
                    while (reader.hasNext()) {
                        name = reader.nextName();
                        if (name.equals("label")) {
                            try {
                                String label = reader.nextString();
//                                afcsv.setOccupationField(label);
                                if (label.equals("Data/IT")) {
                                    willSave = true;
                                }
                            } catch (IllegalStateException e) {
                                reader.skipValue();
                            }
                        } else
                            reader.skipValue();
                    }
                    reader.endObject();
                } else if (name.equals("employer")) {
                    reader.beginObject();
                    while (reader.hasNext()) {
                        name = reader.nextName();
                        try {
                            if (name.equals("name"))
                                afcsv.setEmployer(reader.nextString());
                            else if (name.equals("workplace"))
                                afcsv.setEmploymentType(reader.nextString());
                            else
                                reader.skipValue();
                        } catch (IllegalStateException e) {
                            reader.skipValue();
                        }
                    }
                    reader.endObject();
                } else if (name.equals("workplace_address")) {
                    reader.beginObject();
                    while (reader.hasNext()) {
                        name = reader.nextName();
                        try {
                            if (name.equals("region"))
                                afcsv.setApplicationContacts(reader.nextString());
                            else if (name.equals("street_address"))
                                afcsv.setWorkplaceAddress(reader.nextString());
                            else if (name.equals("postcode"))
                                afcsv.setWorkingHoursType(reader.nextString());
                            else
                                reader.skipValue();
                        } catch (IllegalStateException e) {
                            reader.skipValue();
                        }
                    }
                    reader.endObject();
                } else if (name.equals("description")) {
                    reader.beginObject();
                    while (reader.hasNext()) {
                        name = reader.nextName();
                        try {
                            if (name.equals("text")) {
                                afcsv.setDescription(reader.nextString());
                            } else
                                reader.skipValue();
                        } catch (IllegalStateException e) {
                            reader.skipValue();
                        }
                    }
                    reader.endObject();
                } else if (name.equals("publication_date")) {
                    afcsv.setPublicationDate(reader.nextString());
                } else {
                    reader.skipValue();
                }

//                Afcsv afcsv = new Gson().fromJson(reader, Afcsv.class);
//                System.out.println(afcsv);
//                System.out.println(afservice.save(afcsv));
//                return afcsv.getDescription().toString();
            }
            reader.endObject();
            System.out.println(afcsv.getDetectedLanguage());
//            if (afcsv.getOccupationField()!=null){
//                if(afcsv.getOccupationField().equals("Data/IT")) {
            if (willSave == true) {
                this.save(afcsv);
            }
//                }}
        }
    }
}
