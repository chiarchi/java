package it.spindox.tutor.spindoxspring.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.dialect.function.CastFunction;
import org.springframework.data.util.CastUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.spindox.tutor.spindoxspring.model.People;
import it.spindox.tutor.spindoxspring.service.PeopleService;
import lombok.RequiredArgsConstructor;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RequiredArgsConstructor
@RestController
public class PeopleController {
    private final PeopleService service;

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

/* 
    @GetMapping("/peopleRest")
    CollectionModel<EntityModel<People>> all() {
        List<People> tmp = service.getListPeople();
        List<EntityModel<People>>  people = new ArrayList<EntityModel<People>>();

        for (int i =0; i<tmp.size();i++) {
            <EntityModel>tmp.get(i)
            
        }

  return CollectionModel.of(people, linkTo(methodOn(PeopleController.class).all()).withSelfRel());
} */

}
