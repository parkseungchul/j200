package com.psc.cloud.biz2.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/profile")
	public String profile() {
		return "profile ";
	}


	@GetMapping("/client_a")
	public String client_a() {
		return "client_a ";
	}

	@GetMapping("/client_b")
	public String client_b() {
		return "client_b ";
	}


}
