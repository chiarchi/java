package it.spindox.tutor.spindoxspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.spindox.tutor.spindoxspring.model.People;
import it.spindox.tutor.spindoxspring.service.PeopleService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class PeopleController {
    private final PeopleService service;

    @GetMapping(value ="/person")
    public ResponseEntity<People> getStatus() {
        return new ResponseEntity<>(service.getPeople(), HttpStatus.OK);
    }
}
