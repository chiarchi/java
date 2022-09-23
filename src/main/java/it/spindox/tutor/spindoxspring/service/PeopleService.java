package it.spindox.tutor.spindoxspring.service;

import it.spindox.tutor.spindoxspring.model.People;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

    public People getPeople() {
        return new People("chiara","burato");
    }

}