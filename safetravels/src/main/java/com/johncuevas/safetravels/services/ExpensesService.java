package com.johncuevas.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johncuevas.safetravels.models.ExpensesModel;
import com.johncuevas.safetravels.repositories.ExpensesRepository;

@Service
public class ExpensesService {
	
	private final ExpensesRepository expensesRepository;

	public ExpensesService(ExpensesRepository expensesRepository) {
		this.expensesRepository = expensesRepository;
	}
	
//	RETURNS ALL EXPENSES
	
	public List<ExpensesModel> allExpenses(){
		return expensesRepository.findAll();
	}
	
//	CREATES AN EXPENSE
	
	public ExpensesModel createExpense(ExpensesModel expense) {
		return expensesRepository.save(expense);
	}
	
//	RETRIEVES ONE EXPENSE
	public ExpensesModel findExpense(Long id) {
		Optional<ExpensesModel> optionalExpense = expensesRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}
	
//	UPDATES AN EXPENSE
	public ExpensesModel updateExpense(ExpensesModel expense) {
    	return expensesRepository.save(expense);
    }
	
//	DELETES AN EXPENSE
	public void deleteExpense(Long id) {
    	expensesRepository.deleteById(id);
    }
	

}
