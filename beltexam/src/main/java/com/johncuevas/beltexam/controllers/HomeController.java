package com.johncuevas.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.johncuevas.beltexam.models.Baby;
import com.johncuevas.beltexam.models.User;
import com.johncuevas.beltexam.services.MainService;
import com.johncuevas.beltexam.services.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findOneUser(userId);
		model.addAttribute("user", user);
		model.addAttribute("babyNames", mainService.allBaby());
		return "dashboard.jsp";
	}
	
//	CREATE BABY 
	
	@GetMapping("/names/new")
	public String newBabyForm(@ModelAttribute("baby") Baby baby, HttpSession session) {
		if(session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		return "newBaby.jsp";
	}
	
	@PostMapping("/names/new")
	public String processBabyForm(@Valid @ModelAttribute("baby") Baby baby,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newBaby.jsp";
		}
		else {
			mainService.createBaby(baby);
			return "redirect:/dashboard";
		}
	}
	
//	EDIT BABY
	
	@GetMapping("names/{id}/edit")
	public String editBaby(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId") ==null) {
			return "redirect:/";
		}

		Baby baby = mainService.findOneBaby(id);
		model.addAttribute("baby", baby);
		if( (Long) session.getAttribute("userId") == baby.getCreator().getId()) {
			return "editBaby.jsp";
		}
		return "redirect:/dashboard";
		
	}
	
	@PutMapping("names/{id}/edit")
	public String processEditBaby(@Valid @ModelAttribute("baby") Baby baby,
			BindingResult result) {
		if(result.hasErrors()) {
			return "editBaby.jsp";
		}
		else {
			mainService.updateBaby(baby);
			return "redirect:/dashboard";
		}
	}
		
//	DELETE BABY
	
	@DeleteMapping("names/{id}")
	public String deleteBaby(@PathVariable("id") Long id) {
		mainService.deleteBaby(id);
		return "redirect:/dashboard";
	}
	
//	VIEW ONE BABY
	@GetMapping("names/{id}")
	public String oneBaby(Model model, @PathVariable("id") Long id, HttpSession session) {
		if(session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		model.addAttribute("baby", mainService.findOneBaby(id));
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findOneUser(userId);
		model.addAttribute("user", user);
		return "oneBaby.jsp";
	}
	
//	LIKES
	
	@PutMapping("/names/{id}/like")
	public String likeBaby(@PathVariable("id")Long babyId, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		mainService.likeBaby(babyId, userId);
		return "redirect:/dashboard";
	}
	
	@PutMapping("/names/{id}/unlike")
	public String unlikeBaby(@PathVariable("id")Long babyId, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		mainService.unlikeBaby(babyId, userId);
		return "redirect:/dashboard";
	}
	

}
