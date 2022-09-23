package it.spindox.tutor.spindoxspring.service;

import it.spindox.tutor.spindoxspring.model.People;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PeopleService {

    public People getPeople() {
        return new People("chiara","burato");
    }


    public List<People> getListPeople() {

        List<People> listPeople = new ArrayList<People>();
        listPeople.add(new People("chiara", "burato"));
        listPeople.add(new People("chiara", "burato"));
        
        return listPeople;
    }
}