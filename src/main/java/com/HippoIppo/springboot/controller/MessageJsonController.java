package com.HippoIppo.springboot.controller;

import com.HippoIppo.springboot.dto.User;
import com.HippoIppo.springboot.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
    private RabbitMQJsonProducer jsonProducer;

    public MessageJsonController(RabbitMQJsonProducer jsonProducer){
        this.jsonProducer=jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMesage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }


}
