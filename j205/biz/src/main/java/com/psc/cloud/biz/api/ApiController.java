package com.psc.cloud.biz.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/profile")
	public String profile() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		return "Scopes: " + authentication.getAuthorities() +"/n";
	}


	@GetMapping("/client_a")
	public String client_a() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		return "Scopes admin: " + authentication.getAuthorities() +"/n";
	}

	@GetMapping("/client_b")
	public String client_b() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		return "Scopes user: " + authentication.getAuthorities() +"/n";
	}

	@GetMapping("/deny")
	public String deny() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		return "권한이 적절하지 못함[" + authentication + "]\n";
	}

}
