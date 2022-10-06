package it.spindox.tutor.spindoxspring.manager;

import java.io.File;
import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.spindox.tutor.spindoxspring.model.SpindoxMessage;
import lombok.RequiredArgsConstructor;

@Component
@Configuration
@RequiredArgsConstructor
public class SpindoxMessageManager  {

    ObjectMapper mapper = new ObjectMapper();

    SpindoxMessage serialize(String payload) throws StreamReadException, DatabindException, IOException{
        
        return mapper.readValue(payload, SpindoxMessage.class);
    };

    String deSerialize(SpindoxMessage message) throws JsonProcessingException{

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(message);
    };

}
