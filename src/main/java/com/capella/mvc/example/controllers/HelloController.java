package com.capella.mvc.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class HelloController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(HelloController.class);


	@RequestMapping(value = { "/" })
	public ModelAndView handleRequest() throws Exception {
		ModelAndView model = new ModelAndView("index");
		model.addObject("message", LocalDateTime.now());
		return model;
	}



}