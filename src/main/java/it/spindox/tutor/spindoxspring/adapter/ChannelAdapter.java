package it.spindox.tutor.spindoxspring.adapter;
import it.spindox.tutor.spindoxspring.manager.ChannelManager;
import it.spindox.tutor.spindoxspring.model.People;
import it.spindox.tutor.spindoxspring.model.SpindoxMessage;
import it.spindox.tutor.spindoxspring.repository.MongoDBRep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;


@Service
@Slf4j
@RequiredArgsConstructor
public class ChannelAdapter {


   

    @Autowired
    private final ChannelManager manager;
    @Autowired
    private final MongoDBRep repository;

    @RabbitListener
    public void onMessageReceived(SpindoxMessage message) throws StreamReadException, DatabindException, IOException {

        log.info("do something");
        People person = (People) manager.serializeMessage(message.toString());
        
        repository.save(person);
    }


    //sottoscritto al topic di rabbit
    //ricevo messaggi
        // do somethings --> save db

}