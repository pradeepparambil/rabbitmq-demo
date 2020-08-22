package com.teksenz.rabbitmqdemo;

import lombok.RequiredArgsConstructor;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

    private final RabbitTemplate rabbitTemplate;
    @Value("${teksenz.rabbitmq.exchange}")
    private String exchange;

    @Value("${teksenz.rabbitmq.routingky}")
    private String routingKey;

    @Value("${teksenz.rabbitmq.queue}")
    private String queueName;

    public void produceMessage(String msg){
        rabbitTemplate.convertAndSend(exchange,routingKey,msg);
        System.out.println("Message sent");
    }
    @Bean
    Queue queue(){
        return new Queue(queueName,false);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange(exchange);
    }
    @Bean
    Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

}
