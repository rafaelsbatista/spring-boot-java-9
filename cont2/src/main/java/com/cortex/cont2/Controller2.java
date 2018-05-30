package com.cortex.cont2;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cortex.messagebroker.JacksonMap;

@RestController
public class Controller2 {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(JacksonMap email) {
    	
    }
	@GetMapping(value = "/val2")
	public String val2() {
		return "2";
	}
}
