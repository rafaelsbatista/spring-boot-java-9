package com.cortex.cont2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

	
	@GetMapping(value = "/val2")
	public String val2() {
		return "2";
	}
}
