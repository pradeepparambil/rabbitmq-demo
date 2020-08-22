package com.teksenz.rabbitmqdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final Producer producer;

    @GetMapping("/send")
    public String sendMsg(@RequestParam String message){
        producer.produceMessage(message);
        return "Message sent";
    }
}
