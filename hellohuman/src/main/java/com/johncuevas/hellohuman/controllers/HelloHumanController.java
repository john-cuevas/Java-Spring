package com.johncuevas.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
//	@RequestMapping("/")
//	public String hello() {
//		return "Hello Human";
//	}
	
	@RequestMapping("/")
	public String getname(@RequestParam("name") String firstname, @RequestParam("last_name") String lastname) {
		return "Hello " + firstname +" "+ lastname;
	}
	
////	optional
//	@RequestMapping("/")
//	public String getname(@RequestParam("name") String firstname, @RequestParam("times") String times) {
//		String str = "Hello";
//		String repeated = str.repeat(times);
//		return repeated;
//	}
//	

}
