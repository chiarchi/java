package it.spindox.tutor.spindoxspring.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.spindox.tutor.spindoxspring.model.People;

@Service
public class ProducerService {

    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    @Autowired
    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(People people) {
        System.out.println(exchange);
        System.out.println(routingkey);
        System.out.println(people.getName());
        rabbitTemplate.convertAndSend(exchange,routingkey, people.getName());
    }
}
