package com.psc.sample.j214.controller;

import com.psc.sample.j214.config.SecurityUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/sample")
public class SampleController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/main")
	public String main(Authentication authentication, ModelMap map) {
		
		SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
		map.addAttribute("user", securityUser);
		return "main";
	}

	@RequestMapping("/member")
	public String member() {
		return "member";
	}
	
	@RequestMapping("/manager")
	public String manager() {
		return "manager";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/sampleLayout1")
	public String sampleLayout1() {
		return "sample/sampleLayout1";
	}

	@RequestMapping("/sampleLayout3")
	public String sampleLayout3() {
		return "sample/sampleLayout3";
	}
}
