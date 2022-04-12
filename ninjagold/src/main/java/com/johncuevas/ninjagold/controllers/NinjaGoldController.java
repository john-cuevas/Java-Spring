package com.johncuevas.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	
	@PostMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/gold";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/gold", method = { RequestMethod.GET, RequestMethod.POST})
	public String gold(
			HttpSession session,
			Model model,
			@RequestParam(value = "farm", required = false) String farm,
			@RequestParam(value = "cave", required = false) String cave,
			@RequestParam(value = "house", required = false) String house,
			@RequestParam(value = "quest", required = false) String quest,
			@RequestParam(value = "spa", required = false) String spa
			
			) {
		
		SimpleDateFormat format = new SimpleDateFormat("MMM d Y h:mm a");
		Integer gold = 0;
		ArrayList<String> actions = new ArrayList<String>();
		
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("actions", actions);
		} 
		else {
			gold = (Integer) session.getAttribute("gold");
			actions = (ArrayList<String>) session.getAttribute("actions");
			session.setAttribute("actions", actions);
		}
		
		if(farm != null) {
			Integer amount = new Random().nextInt(11) + 10;
			gold += amount;
			session.setAttribute("gold", gold);
			actions.add(0, "You entered a farm and earned " + amount + " gold. "
					+ "(" +format.format(new Date()) + ")");
			
			return "redirect:/gold";
		}
		
		if(cave != null) {
			Integer amount = new Random().nextInt(6) + 5;
			gold += amount;
			session.setAttribute("gold", gold);
			actions.add(0, "You entered a farm and earned " + amount + " gold. "
					+ "(" +format.format(new Date()) + ")");
			
			return "redirect:/gold";
		}
		
		if(house != null) {
			Integer amount = new Random().nextInt(4) + 2;
			gold += amount;
			session.setAttribute("gold", gold);
			actions.add(0, "You entered a farm and earned " + amount + " gold. "
					+ "(" +format.format(new Date()) + ")");
			
			return "redirect:/gold";
			
		}
		
		if(spa != null) {
			Integer amount = new Random().nextInt(16) + 5;
			gold += amount;
			session.setAttribute("gold", gold);
			actions.add(0, "You entered a spa and lost " + (amount * -1) + " gold. "
					+ "(" +format.format(new Date()) + ")");
			
			return "redirect:/gold";
			
		}
		
		if(quest != null) {
			Integer amount = new Random().nextInt(101) - 50;
			gold += amount;
			session.setAttribute("gold", gold);
			if(amount<0) {
				actions.add(0, "You failed the quest and lost " + (amount * -1) + " gold. Ouch. (" + format.format(new Date()) + ")");
			}else {
				actions.add(0, "You completed the quest and earned " + amount + " gold. (" + format.format(new Date()) + ")");
			}
			return "redirect:/gold";
			
		}
		
		
		return "form.jsp";
		
	}

}
