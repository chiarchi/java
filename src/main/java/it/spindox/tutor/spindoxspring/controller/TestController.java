package it.spindox.tutor.spindoxspring.controller;

import it.spindox.tutor.spindoxspring.service.CustomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class TestController {

    private final CustomService service;

    @GetMapping(value="/hello")
    public ResponseEntity<String> hello() {
        String result = service.getResult();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
