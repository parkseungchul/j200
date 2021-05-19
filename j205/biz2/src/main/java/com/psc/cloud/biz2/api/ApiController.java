package com.psc.cloud.biz2.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/profile")
	public String profile() {
		return "Scopes profile";
	}


	@GetMapping("/client_a")
	public String client_a() {
		return "Scopes client_a";
	}

	@GetMapping("/client_b")
	public String client_b() {
		return "Scopes client_b";
	}
}
