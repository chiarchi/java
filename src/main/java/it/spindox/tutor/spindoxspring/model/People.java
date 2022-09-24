package it.spindox.tutor.spindoxspring.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class People {
    

    private String name;
    private String surname;
    @Id
    private int id;
    
}
