package it.spindox.tutor.spindoxspring.service;

import it.spindox.tutor.spindoxspring.model.Status;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    public Status getStatus() {
        return new Status("OK", "I am ok!");
    }

}
