package it.spindox.tutor.spindoxspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.spindox.tutor.spindoxspring.model.People;

public interface MongoDBRepository extends MongoRepository<People, Integer> { }
