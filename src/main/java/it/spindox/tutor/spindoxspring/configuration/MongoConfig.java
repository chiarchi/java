package it.spindox.tutor.spindoxspring.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import it.spindox.tutor.spindoxspring.model.People;
import it.spindox.tutor.spindoxspring.repository.MongoDBRepository;

@EnableMongoRepositories(basePackageClasses = MongoDBRepository.class)
@Configuration
public class MongoConfig {
    @Bean
    CommandLineRunner commandLineRunner(MongoDBRepository userRepository) {
        return strings -> {
            userRepository.save(new People("Ryan", "Calvin", 1));
            userRepository.save(new People("Ryan", "Bryson", 2));
        };
    }
}
