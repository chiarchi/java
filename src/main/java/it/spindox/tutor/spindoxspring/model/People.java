package it.spindox.tutor.spindoxspring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
@Document
@Getter
@Setter
public class People {
    

    private String name;
    private String surname;
    @Id
    private int id;
    
}
