package com.capella.mvc.example.controllers;

import java.net.InetAddress;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.Jedis;

@Controller
public class HelloController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(HelloController.class);

    @Autowired
    private Jedis jedis;

    public HelloController() {

    }

	@RequestMapping(value = { "/" })
    public ModelAndView handleRequest(HttpServletRequest request) throws Exception {
        if (!jedis.exists("COUNT")) {
            jedis.set("COUNT", "0");
        }

		ModelAndView model = new ModelAndView("index");
        model.addObject("dateTime", LocalDateTime.now());
        model.addObject("hostName", InetAddress.getLocalHost());
        model.addObject("sessionId", request.getSession().getId());
        model.addObject("count", jedis.incr("COUNT"));
        return model;
	}
}