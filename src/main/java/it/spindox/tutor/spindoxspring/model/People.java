package it.spindox.tutor.spindoxspring.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    private String surname;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
}
