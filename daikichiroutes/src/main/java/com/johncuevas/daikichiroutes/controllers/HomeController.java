package com.johncuevas.daikichiroutes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/test")
	public String test() {
		return "test.jsp";
	}
	
	@RequestMapping("/test2")
	public String test2() {
		return "test2.jsp";
	}

}
