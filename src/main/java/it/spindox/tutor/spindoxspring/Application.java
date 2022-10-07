package it.spindox.tutor.spindoxspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = {"it.spindox.tutor.spindoxspring"})
public class Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
