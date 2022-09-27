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
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
@Service
public class clientService {


   

    @Autowired
    MongoDBRepository repository;
    private RabbitTemplate rabbitTemplate;
    
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    @Autowired
    public clientService(MongoDBRepository MongoDBRepository, RabbitTemplate rabbitTemplate) {
        this.repository = MongoDBRepository;
        this.rabbitTemplate = rabbitTemplate;
    }


     //cunsumer
    @RabbitListener
    public void receivedMessage(People user) {
        People save = repository.save(user);
    }

    //producer

    public void sendMessage(People people) {
        System.out.println(exchange);
        System.out.println(routingkey);
        System.out.println(people.getName());
        rabbitTemplate.convertAndSend(exchange,routingkey, people.getName());
    }

}