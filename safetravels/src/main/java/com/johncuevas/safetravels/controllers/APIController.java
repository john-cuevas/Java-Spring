package com.johncuevas.safetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.johncuevas.safetravels.models.ExpensesModel;
import com.johncuevas.safetravels.services.ExpensesService;

@RestController
public class APIController {
	
	private final ExpensesService expensesService;

	public APIController(ExpensesService expensesService) {
		this.expensesService = expensesService;
	}
	
//	FIND ALL EXPENSES
	@GetMapping("/api/expenses")
	public List <ExpensesModel> getAll(){
		return expensesService.allExpenses();
	}
	
//	CREATE EXPENSE
	@PostMapping("/api/expenses")
	public ExpensesModel createExpense(
			@RequestParam("expense") String expense,
			@RequestParam("vendor") String vendor,
			@RequestParam("description") String description,
			@RequestParam("amount") Double amount
			) {
		ExpensesModel newExpense = new ExpensesModel(expense, vendor, description, amount);
		return expensesService.createExpense(newExpense);
	}
	
//	UPDATE EXPENSE
	@PutMapping("/api/expenses/{id}")
	public ExpensesModel updateExpense(
			@PathVariable("id") Long id,
			@RequestParam("expense") String expense,
			@RequestParam("vendor") String vendor,
			@RequestParam("description") String description,
			@RequestParam("amount") Double amount
			) {
		ExpensesModel updatedExpense = new ExpensesModel(expense, vendor, description, amount);
		updatedExpense.setId(id);
		return expensesService.updateExpense(updatedExpense);
	}
	
//	DELETE EXPENSE
	@DeleteMapping("/api/expenses/{id}")
	public void destroy(@PathVariable("id") Long id) {
		expensesService.deleteExpense(id);
	}

}
