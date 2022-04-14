package com.johncuevas.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.johncuevas.dojosandninjas.models.Dojo;
import com.johncuevas.dojosandninjas.services.MainService;

@Controller
public class DojoController {
	
	@Autowired
	private MainService mainService;
	
//	CREATE NEW DOJO 
//	1. Render Form
//	2. Process Form
	
	@GetMapping("/dojos/new")
	public String dojoForm(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojoForm.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String processDojoForm(@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newDojoForm.jsp";
		}
		else {
			mainService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
//	GET ONE DOJO
	@GetMapping("/dojos/{id}")
	public String oneDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = mainService.findOneDojo(id);
		model.addAttribute("dojo", dojo);
//		model.addAttribute("ninjas", mainService.allNinjas());
		return "oneDojo.jsp";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test.jsp";
	}

}
