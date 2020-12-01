package com.psc.j203.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BascController {
	
	
	@RequestMapping(value = {"/", "/list"})
	public String list() {
		return "list";
	}
	
	@RequestMapping("edit")
	public String edit() {
		return "edit";
	}
	
	@RequestMapping("delete")
	public String delete() {
		return "forward:/";
	}
	
	

}
