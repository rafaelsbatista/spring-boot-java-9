package com.cortex.main;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cortex.messagebroker.JacksonMap;


@RestController
public class Controller1 {
	//
	// // Send a message with a POJO - the template reuse the message converter
	// System.out.println("Sending an email message.");
	// jmsTemplate.convertAndSend("mailbox", new Email("info@example.com"
    static String lastValue = "";
    
    @KafkaListener(id = "foo", topics = "annotated1")
    public void listen1(String foo) {
        lastValue = foo;
    }
	@GetMapping(value = "/val1")
	public String vai() {
		JacksonMap aa = new JacksonMap();
		return "1 " + lastValue;
	}
}
