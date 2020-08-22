package com.teksenz.rabbitmqdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "${teksenz.rabbitmq.queue}")
    public void listen(String msg){
        System.out.println("Message received - "+msg);
    }
}
