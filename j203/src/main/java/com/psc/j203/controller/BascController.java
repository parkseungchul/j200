package com.psc.j203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psc.j203.service.DeptService;

@Controller
public class BascController {
	
	@Autowired
	private DeptService deptService;
	
	
	@RequestMapping(value = {"/", "/list"})
	public String list(ModelMap map) {
		
		map.addAttribute("deptList", deptService.list());
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
