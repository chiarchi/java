package it.spindox.tutor.spindoxspring.manager;

import it.spindox.tutor.spindoxspring.model.SpindoxMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@Component
@RequiredArgsConstructor
public abstract class ChannelManager {

    private final SpindoxMessageManager messageManager;

    //PEOPLE
   // public abstract void receivedMessage(People people);
   // public abstract void sendMessage(People people);

    public void sendMessage(SpindoxMessage message) {

        String payload = messageManager.deSerialize(message);

        log.info("it works");
    }

    public SpindoxMessage serializeMessage(String payload) {

        SpindoxMessage message = messageManager.serialize(payload);

        log.warning("todo");
        return null;
    }

    //public Message


}
