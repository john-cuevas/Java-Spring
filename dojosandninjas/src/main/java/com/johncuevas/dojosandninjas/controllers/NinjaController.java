package com.johncuevas.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.johncuevas.dojosandninjas.models.Ninja;
import com.johncuevas.dojosandninjas.services.MainService;

@Controller
public class NinjaController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/ninjas/new")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", mainService.allDojos());
		return "newNinjaForm.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String processNinjaForm(@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", mainService.allDojos());
			return "newNinjaForm.jsp";
		}
		else {
			mainService.createNinja(ninja);
			return "redirect:/";
		}
	}

}
