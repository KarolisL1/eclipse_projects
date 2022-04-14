package com.codingdojo.travel.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping("/expenses/{expenseId}")
    public String show_one(Model model, @PathVariable("expenseId") Long expenseId) {
    	model.addAttribute("expense", expenseService.ReadOne(expenseId));
    	return "expense";
    }
    
    @RequestMapping("/expenses/{expenseId}/edit")
    public String edit(@PathVariable("expenseId") Long id, Model model) {
        Expense expense = expenseService.ReadOne(id);
        if(expense==null) return "redirect:/expenses";
        model.addAttribute("expense", expense);
        return "edit_expense";
    }
    
    @PostMapping(value="/expenses/{expenseId}/update")
    public String expense_update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_expense";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
    }
    
    @GetMapping(value="/expenses/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }

    
    @RequestMapping("/expenses")
    public String index(Model model, @ModelAttribute("expense") Expense expense) {
        List<Expense> expenses = expenseService.allExpenses();
        model.addAttribute("expenses", expenses);
        return "index";
    }
    

}
