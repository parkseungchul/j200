package com.psc.j203.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBaseController {

	@Autowired
	protected MockMvc mockMvc;
	
	@Test
	@Order(1)
	public void list() throws Exception {
		MvcResult result = mockMvc.perform(get("/list"))
				.andDo(print())
				.andExpect(status().is(HttpStatus.OK.value()))
				.andReturn();
		
		String content = result.getResponse().getContentAsString();
		Assertions.assertThat(content).contains(
				String.valueOf(10)
				, String.valueOf(20)
				, String.valueOf(30)
				, String.valueOf(40)
		);
	}
	
	@Test
	@Order(2)
	public void edit() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("deptno", String.valueOf(10));

		MvcResult result = mockMvc.perform(get("/edit").params(params))
				.andDo(print())
				.andExpect(status().is(HttpStatus.OK.value()))
				.andReturn();
		
		String content = result.getResponse().getContentAsString();
		Assertions.assertThat(content).contains(
				String.valueOf(10)
				, "ACCOUNTING"
				, "NEW YORK"
		);
	}	
	
	@Test
	@Order(3)
	public void delete() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("deptno", String.valueOf(10));

		mockMvc.perform(post("/delete").params(params))
				.andDo(print())
				.andExpect(status().is(HttpStatus.OK.value()))
				.andExpect(forwardedUrl("/"))
				.andReturn();
	
	}
}
