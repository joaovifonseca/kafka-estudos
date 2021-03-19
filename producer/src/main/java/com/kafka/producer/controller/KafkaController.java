package com.kafka.producer.controller;

import com.kafka.producer.broker.TopicProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final TopicProducer topicProducer;

    @GetMapping(value = "/send")
    @ResponseBody
    public void send(HttpEntity<String> httpEntity){
        String body = httpEntity.getBody();
        topicProducer.send(body);
    }
}
