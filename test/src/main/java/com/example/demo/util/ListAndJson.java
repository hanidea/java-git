package com.example.demo.util;

import com.example.demo.exception.http.ServerErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import java.util.List;

public class ListAndJson implements AttributeConverter<List<Object>,String> {
    @Autowired
    private ObjectMapper mapper;
    @Override
    public String convertToDatabaseColumn(List<Object> objects) {
        try{
            return mapper.writeValueAsString(objects);
        }catch(JsonProcessingException e){
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    public List<Object> convertToEntityAttribute(String s) {
        try {
            if(s == null){
                return null;
            }
            return mapper.readValue(s, List.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
