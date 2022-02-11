package com.psc.sample.j213.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutController {

	@RequestMapping("/1")
	public String layout1(){
		return "single";
	}

	@RequestMapping("/2")
	public String layout2(){
		return "double";
	}
}
