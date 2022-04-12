package com.johncuevas.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	
//	Render Form
	
	@GetMapping("/")
	public String form() {
		return "form.jsp";
	}
	
//	Process Form
	@PostMapping("/processForm")
	public String processForm(
			@RequestParam("number") Integer number,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("hobby") String hobby,
			@RequestParam("living") String living,
			@RequestParam("comment") String comment,
			HttpSession session
			) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("comment", comment);
		return "redirect:/result";
	}
	
//	Show Form Results
	@GetMapping("/result")
	public String formResult() {
		return "formResult.jsp";
	}

}
