package it.spindox.tutor.spindoxspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;



@Entity
public interface SpindoxMessage {

    String payload ="";
    
    @NotBlank(message = "name is mandatory")
    public String name ="";

    @NotBlank(message = "Surname is mandatory")
    public String surname = "";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id = 0;
   
}
