package it.spindox.tutor.spindoxspring.controller;

import it.spindox.tutor.spindoxspring.model.Status;
import it.spindox.tutor.spindoxspring.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StatusController {

    private final StatusService service;

    @GetMapping(value ="/status")
    public ResponseEntity<Status> getStatus() {
        return new ResponseEntity<>(service.getStatus(), HttpStatus.OK);
    }

}
