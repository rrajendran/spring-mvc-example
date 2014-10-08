package com.capella.ping.server.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capella.ping.server.entity.Ping;
import com.capella.ping.server.utils.PseudoPing;
import com.capella.ping.server.utils.TelnetClientUtil;

@org.springframework.stereotype.Controller
public class HelloController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(HelloController.class);


	@RequestMapping(value = { "/index", "/" })
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LOGGER.info("Returning hello view");
		ModelAndView modelAndView = new ModelAndView("/index");
		Ping ping = new Ping("localhost", 389);
		TelnetClientUtil.telnet(ping );

		modelAndView.addObject("message",  ping);
		return modelAndView;
	}
	@RequestMapping(value = { "/login"  })
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Returning hello view");
		ModelAndView modelAndView = new ModelAndView("/login");
		return modelAndView;
	}
	@RequestMapping(value = { "/tables"  })
	public ModelAndView tables(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Returning hello view");
		ModelAndView modelAndView = new ModelAndView("/tables");
		return modelAndView;
	}
	@RequestMapping(value = { "/forms"  })
	public ModelAndView forms(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Returning hello view");
		ModelAndView modelAndView = new ModelAndView("/forms");
		return modelAndView;
	}
	@RequestMapping(value = { "/blank"  })
	public ModelAndView blank(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Returning hello view");
		ModelAndView modelAndView = new ModelAndView("/blank");
		return modelAndView;
	}
	@RequestMapping(value = { "/buttons"  })
	public ModelAndView buttons(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Returning hello view");
		ModelAndView modelAndView = new ModelAndView("/buttons");
		return modelAndView;
	}
	@RequestMapping(value = { "/flot"  })
	public ModelAndView flot(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Returning hello view");
		ModelAndView modelAndView = new ModelAndView("/flot");
		return modelAndView;
	}


}