package com.codingdojo.travel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.travel.models.Expense;
import com.codingdojo.travel.services.ExpenseService;

@Controller
public class TravelController {
	@Autowired
	private ExpenseService expenseService;
	
	public TravelController(ExpenseService expenseService)
	{
		this.expenseService=expenseService;
	}
	
    @PostMapping("/expenses")
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        } else {
            expenseService.createExpense(expense);
            return "redirect:/expenses";
        }
    }
    
    @RequestMapping("/expenses")
    public String index(Model model, @ModelAttribute("expense") Expense expense) {
        List<Expense> expenses = expenseService.allExpenses();
        System.out.println(expenses);
        model.addAttribute("expenses", expenses);
        return "index";
    }
}
