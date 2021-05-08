package com.avm.controller;

import com.avm.entities.Seasons;
import com.avm.repositories.SeasonsRepository;
import com.avm.repositories.StatusRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formulaOne")
public class RestControllerApi {
    @Autowired
    StatusRepository statusRepository;

    @Autowired
    SeasonsRepository seasonsRepository;

    @GetMapping(path =   "/seasons",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSeasons(){
        ObjectMapper objectMapper = new ObjectMapper();
        // List<Status> list = new ArrayList<Status>();
        Iterable<Seasons> list = seasonsRepository.findAll();
        String result = null;
        try{
            result= objectMapper.writeValueAsString(list);    
        }
        catch(Exception e){
            e.printStackTrace();
            result = "exception";
        }
        return result;
    }

}
