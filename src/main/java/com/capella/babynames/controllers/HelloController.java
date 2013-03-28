package com.capella.babynames.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capella.babynames.command.BabyNames;
import com.capella.babynames.service.JsoupService;

@org.springframework.stereotype.Controller
public class HelloController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(HelloController.class);
	@Autowired
	private JsoupService jsoupService;

	@RequestMapping(value = { "/index", "/" })
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Returning hello view");
		ModelAndView modelAndView = new ModelAndView("/index");
		modelAndView.addObject("babyNames", new BabyNames());
		return modelAndView;
	}

	@RequestMapping(value = { "/populateBabyNames" }, method = RequestMethod.POST)
	public ModelAndView populate(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("babyNames") BabyNames babyNames,
			BindingResult result) throws ServletException, IOException {
		LOGGER.info("Returning populateBabyNames view : "
				+ babyNames.getStartYear());
		ModelAndView model = new ModelAndView("populateBabyNames");
		model.addObject("namesMap", jsoup(babyNames));
		return model;
	}

	@SuppressWarnings("unused")
	private TreeMap<String, Integer> jsoup(BabyNames babyNames)
			throws IOException {
		Map<String,Integer> birthNamesMap = new HashMap<String, Integer>();
		
		for (int i = babyNames.getStartYear(); i <= babyNames.getEndYear(); i++) {
			LOGGER.debug("Fetching statics for the year " + i);
			Document doc = jsoupService.call(i, babyNames.getTop());
			if (doc != null)
				birthNamesMap = jsoupService.extractElements(birthNamesMap,doc);
		}
		return jsoupService.sort(birthNamesMap);

	}

}