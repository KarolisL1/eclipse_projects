package com.codingdojo.dojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojo.models.Ninja;
import com.codingdojo.dojo.services.DojoService;
import com.codingdojo.dojo.services.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}
	
	@GetMapping("/ninjas")
	public String index(Model model) {
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("ninjas", ninjaService.allNinjas());
		model.addAttribute("dojos", dojoService.allDojos());
		return "new_ninja";
	}
	
	@PostMapping("/ninjas/new")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "new_ninja";
		}else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String show_dojos(@PathVariable ("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.ReadOne(id));
		return "dojos";
	}
	
	
}
