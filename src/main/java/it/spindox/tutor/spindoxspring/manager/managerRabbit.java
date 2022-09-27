package it.spindox.tutor.spindoxspring.manager;

import org.springframework.stereotype.Service;

import it.spindox.tutor.spindoxspring.model.People;

@Service
public abstract class managerRabbit {
    //PEOPLE
    public abstract void receivedMessage(People people);
    public abstract void sendMessage(People people);
}
