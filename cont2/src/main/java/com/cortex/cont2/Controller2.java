package com.cortex.cont2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {
    @Autowired
    private KafkaTemplate<Integer, String> template;
    
    @GetMapping(value = "/val2")
    public String val2() {
        template.send("topico", new Integer(2), "valor");
        return "2";
    }
}