package com.cortex.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cortex.messagebroker.JacksonMap;


@RestController
public class Controller1 {
	@Autowired
	JmsTemplate jmsTemplate;
	//
	// // Send a message with a POJO - the template reuse the message converter
	// System.out.println("Sending an email message.");
	// jmsTemplate.convertAndSend("mailbox", new Email("info@example.com",
	@GetMapping(value = "/val1")
	public String vai() {
		JacksonMap aa = new JacksonMap();
		jmsTemplate.convertAndSend("mailbox", aa);
		return "1";
	}
}
