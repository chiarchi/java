package it.spindox.tutor.spindoxspring.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.spindox.tutor.spindoxspring.model.People;
import it.spindox.tutor.spindoxspring.repository.MongoDBRepository;

@Service
public class ConsumerService {

    @Autowired
    MongoDBRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    public ConsumerService(MongoDBRepository MongoDBRepository) {
        this.repository = MongoDBRepository;
    }

    @RabbitListener
    public void receivedMessage(People user) {
        People save = repository.save(user);
        logger.info("persisted " + save);
        logger.info("User recieved: " + user);
    }

}

