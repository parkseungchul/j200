package com.psc.j203.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psc.j203.domain.Dept;
import com.psc.j203.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public String edit(Integer deptno, ModelMap map) {
		Optional<Dept> deptOpt = deptService.getDept(deptno);
		log.debug(deptOpt.get().toString());
		
		
		map.addAttribute("dept", deptOpt.get());
		
		
		return "edit";
	}
	
	@PostMapping("delete")
	public String delete(Integer deptno) {
		
		deptService.delete(deptno);
		
		return "forward:/";
	}
	
	

}
