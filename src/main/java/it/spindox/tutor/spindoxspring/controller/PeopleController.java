package it.spindox.tutor.spindoxspring.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import it.spindox.tutor.spindoxspring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.spindox.tutor.spindoxspring.adapter.ChannelAdapter;
import it.spindox.tutor.spindoxspring.model.People;
import it.spindox.tutor.spindoxspring.service.PeopleService;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RestController
public class PeopleController{
    private final PeopleService service;

    @Autowired
    MongoDBRep peopleRepository;

    @Autowired
    PeopleService peopleService;

    @Autowired
    private clientService ClientService;

    @GetMapping(value ="/person")
    public ResponseEntity<People> getPerson() {
        return new ResponseEntity<>(service.getPeople(), HttpStatus.OK);
    }

    @GetMapping("/people/{id}")
    public Optional<Object> getPeople(@PathVariable("id") int id) {
        return peopleService.findPeopleById(id);
    }

    @GetMapping("/people")
    public List<Object> listPeople() {
        return peopleService.findPeople();
    }

    @PostMapping("/people")
    public void addPerson(@Valid @RequestBody People people) {
        peopleService.saveOrUpdate(people);  
        ClientService.sendMessage(people);
        System.out.println(people.getName());
    }

    @DeleteMapping("/people/{id}")
    public void deletePerson(@PathVariable("id") int id) {
        peopleService.deleteEmployeeById(id);
    }

    @PutMapping(value = "/people/{id}")
    public void updatePeople(@PathVariable int id, @Valid @RequestBody People people) {

        peopleService.findPeopleById(id);
        peopleService.saveOrUpdate(people);
    }

}
