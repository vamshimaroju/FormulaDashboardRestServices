package com.avm.controller;

import java.util.ArrayList;
import java.util.List;

import com.avm.entities.Status;
import com.avm.repositories.StatusRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/home")
public class RestControllerApi {
    @Autowired
    StatusRepository statusRepository;


    @GetMapping("/")
    public String welcomePage(){
        ObjectMapper objectMapper = new ObjectMapper();
        // List<Status> list = new ArrayList<Status>();
        Iterable<Status> list = statusRepository.findAll();
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
