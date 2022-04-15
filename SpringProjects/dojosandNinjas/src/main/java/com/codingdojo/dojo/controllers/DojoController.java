package com.codingdojo.dojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojo.models.Dojo;
import com.codingdojo.dojo.services.DojoService;

@Controller
public class DojoController {
	@Autowired
	private DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@GetMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		System.out.println("home route");
		return "new_dojo";
	}
	
	@PostMapping("/dojos/new")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo,BindingResult result, Model model) 
	{
		System.out.println("hit the post " + result);
		if (result.hasErrors()) {
			return "new_dojo";
		}	
		dojoService.createDojo(dojo);
		return "redirect:/";
		
	}

}
