package com.example.Service;

import com.example.Model.Afcsv;
import com.example.Repository.AfcsvRepo;
import com.google.gson.stream.JsonReader;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    public Afcsv getItem(Integer id){
        return repository.findById(id).get();
    }

    public Collection<Afcsv> getXAmount(int xAmount){
        Pageable limit = PageRequest.of(0,xAmount);
        return repository.findAll(limit).get().collect(Collectors.toList());

    }

    public Afcsv save(Afcsv afcsv){
        return repository.save(afcsv);
    }

    public void readAfcsvFromFile() throws IOException {
        InputStream input = new FileInputStream("C:\\reporoot\\setPace\\Database\\src\\main\\resources\\2021_first_6_months.json");
        JsonReader reader = new JsonReader(new InputStreamReader(input));
        reader.setLenient(true);
        reader.beginArray();
        while (reader.hasNext()) {
            reader.beginObject();
            Afcsv afcsv = new Afcsv();
            while (reader.hasNext()) {

                String name = reader.nextName();
//                if (name.equals("id")) {
//                    afcsv.setId(reader.nextInt());
//                }
//                else if(name.equals("external_id")){
//                    System.out.println(reader.nextString());
//                }
//                else if (name.equals("webpage_url")) {
//                    afcsv.setWebpageUrl(reader.nextString());
//                }
                if(name.equals("headline")){
                    afcsv.setHeadline(reader.nextString());
                }
                else if(name.equals("occupation_field")){
                    reader.beginObject();
                    while (reader.hasNext()){
                        name = reader.nextName();
                        if(name.equals("label")) {
                            try {
                                String label = reader.nextString();
                                afcsv.setOccupationField(label);
                            }catch(IllegalStateException e){
                                reader.skipValue();
                            }
                        }
                        else
                            reader.skipValue();
                    }
                    reader.endObject();
                }
                else if (name.equals("employer")){
                    reader.beginObject();
                    while(reader.hasNext()){
                        name = reader.nextName();
                        if(name.equals("name"))
                            afcsv.setEmployer(reader.nextString());
                        else
                            reader.skipValue();
                    }
                    reader.endObject();
                }
                else if (name.equals("description")) {
                    reader.beginObject();
                    while (reader.hasNext()) {
                        name = reader.nextName();
                        if (name.equals("text")) {
                            afcsv.setDescription(reader.nextString());
                        } else
                            reader.skipValue();
                    }
                    reader.endObject();
                }
                else if(name.equals("publication_date")){
                    afcsv.setPublicationDate(reader.nextString());
                }
                else {
                    reader.skipValue();
                }

//                Afcsv afcsv = new Gson().fromJson(reader, Afcsv.class);
//                System.out.println(afcsv);
//                System.out.println(afservice.save(afcsv));
//                return afcsv.getDescription().toString();
            }
            reader.endObject();
            System.out.println(afcsv.getOccupationField());
            if (afcsv.getOccupationField()!=null){
                if(afcsv.getOccupationField().equals("Data/IT")) {
                    this.save(afcsv);
                    System.out.println("BINGOOOOOOOOOOOOOO");
                }}
        }
    }
}
