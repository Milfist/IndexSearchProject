package org.milfist.controllers;

import org.milfist.services.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import twitter4j.TwitterException;


@RestController
public class AppRestController {
	
	@Autowired
	private TwitterService service;

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
	public String listar(String filter) throws TwitterException {
		return service.getTwitts(filter).iterator().next();
	}

	
}
