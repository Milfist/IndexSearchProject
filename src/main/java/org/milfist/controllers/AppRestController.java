package org.milfist.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppRestController {

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
	public String listar() {
		return "hola";
	}

	
}
