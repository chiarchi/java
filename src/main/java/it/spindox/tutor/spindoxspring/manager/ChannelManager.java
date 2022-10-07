package it.spindox.tutor.spindoxspring.manager;

import it.spindox.tutor.spindoxspring.model.SpindoxMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;



@Log
@Component
@RequiredArgsConstructor
public class ChannelManager {

    private final SpindoxMessageManager messageManager;


    public void sendMessage(SpindoxMessage message) throws JsonProcessingException {

        String payload = messageManager.deSerialize(message);

        log.info("payload: " + payload);
    }

    public SpindoxMessage serializeMessage(String payload) throws StreamReadException, DatabindException, IOException {

        SpindoxMessage message = messageManager.serialize(payload);

        log.warning("todo");
        return message;
    }



    //public Message


}
