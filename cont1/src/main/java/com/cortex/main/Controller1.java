package com.cortex.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller1 {

	@GetMapping(value = "/val1")
	public String vai() {
		return "1";
	}
}
