package com.johncuevas.safetravels.controllers;

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

import com.johncuevas.safetravels.models.ExpensesModel;
import com.johncuevas.safetravels.services.ExpensesService;

@Controller
public class ExpenseController {
	
	@Autowired
	ExpensesService expensesService;
	
//	GET ALL EXPENSES
	
	@GetMapping("/expenses")
	public String allExpenses(Model model) {
		model.addAttribute("expenses", expensesService.allExpenses() );
		return "allExpenses.jsp";
	}
	
	
	
//	RENDER THE FORM
	
	@GetMapping("/expenses/new")
	public String newExpense(@ModelAttribute("expense") ExpensesModel expense) {

		return "new.jsp";
	}
	
//	PROCESS THE FORM
	
	@PostMapping("/expenses/new")
	public String create(@Valid @ModelAttribute("expense") ExpensesModel expense, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		else {
			expensesService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
//	EDIT EXPENSE
	@GetMapping("/expenses/{id}/edit")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		ExpensesModel expense = expensesService.findExpense(id);
		model.addAttribute("expense", expense );
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/{id}/edit")
	public String processEdit(@Valid @ModelAttribute("expense") ExpensesModel expense, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			expensesService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
//	DELETE EXPENSE
	@DeleteMapping("/expenses/{id}")
	public String destroy(@PathVariable("id") Long id) {
		expensesService.deleteExpense(id);
		return "redirect:/expenses";
	}
	
//	GET ONE EXPENSE
	@GetMapping("/expenses/{id}")
	public String ONEExpense(@PathVariable("id") Long id, Model model) {
		ExpensesModel expense = expensesService.findExpense(id);
		model.addAttribute("expense", expense );
		return "one.jsp";
	}
	
}
