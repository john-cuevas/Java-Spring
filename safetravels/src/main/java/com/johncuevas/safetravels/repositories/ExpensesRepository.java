package com.johncuevas.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.johncuevas.safetravels.models.ExpensesModel;

@Repository
public interface ExpensesRepository extends CrudRepository<ExpensesModel, Long>{

//	find all expenses
	
	List<ExpensesModel> findAll();

}
