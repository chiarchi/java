package it.spindox.tutor.spindoxspring.controller;

import java.util.List;
import it.spindox.tutor.spindoxspring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.spindox.tutor.spindoxspring.model.People;
import it.spindox.tutor.spindoxspring.service.PeopleService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class PeopleController {
    private final PeopleService service;

    @Autowired
    MongoDBRepository peopleRepository;

    @Autowired
    PeopleService peopleService;

    @GetMapping(value ="/person")
    public ResponseEntity<People> getPerson() {
        return new ResponseEntity<>(service.getPeople(), HttpStatus.OK);
    }

    @GetMapping(value ="/people")
    public ResponseEntity<List<People>> getPeople() {
        System.out.print("all");
        return new ResponseEntity<>(service.getListPeople(), HttpStatus.OK);
    }

    @GetMapping("/people/{id}")
    People one(@PathVariable("id") int id) {

        People people = service.findById(id);
        System.out.print(people.getName());
        return people;
    }

    @GetMapping("/peopleDB")
    public List<People> list() {
        return peopleRepository.findAll();
    }

    @PostMapping("/peopleDB")
    public void addPerson(@RequestBody People employee) {
        peopleService.saveOrUpdate(employee);   
    }

    @DeleteMapping("/peopleDB/{id}")
    public void deletePerson(@PathVariable("id") int id) {
        peopleService.deleteEmployeeById(id);
    }
}
