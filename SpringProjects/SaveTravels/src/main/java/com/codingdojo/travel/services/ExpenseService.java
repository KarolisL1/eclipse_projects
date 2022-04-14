package com.codingdojo.travel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.travel.models.Expense;
import com.codingdojo.travel.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses(){
		return expenseRepository.findAll();
	}
	
	//create a expense
	public Expense createExpense(Expense e) {
		return expenseRepository.save(e);
	}
	
	//deletes an expense
	public void deleteExpense(Long Id) {
		expenseRepository.deleteById(Id);
	}
	
	public void updateExpense(Expense e) {
			createExpense(e);
	}
	
	public Expense ReadOne(Long id) {
		Optional<Expense> expense=expenseRepository.findById(id);
		return expense.isPresent()?expense.get():null;
	}
}
