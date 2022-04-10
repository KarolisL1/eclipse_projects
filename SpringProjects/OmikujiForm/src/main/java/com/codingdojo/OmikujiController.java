package com.codingdojo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class OmikujiController
{
	/* flash attribute redirect fix: */
	/* org.springframework.validation.BindingResult.model_name */
	
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public String send(
		@RequestParam(value="number") Integer number,
	    @RequestParam(value="city") String city,
	    @RequestParam(value="name") String name,
		@RequestParam(value="hobby") String hobby,
		@RequestParam(value="thing") String thing,
		@RequestParam(value="somethingnice") String somethingnice, HttpSession session ){
		
		session.setAttribute("numberToShow", number);
		session.setAttribute("cityToShow", city);
		session.setAttribute("nameToShow", name);
		session.setAttribute("hobbyToShow", hobby);
		session.setAttribute("thingToShow", thing);
		session.setAttribute("somethingniceToShow", somethingnice);
		
	    return "redirect:/show";
	}
	
	@RequestMapping("/show")
	public String confirmationPage(Model model, HttpSession session){
		model.addAttribute("number", session.getAttribute("numberToShow"));
		model.addAttribute("city", session.getAttribute("cityToShow"));
		model.addAttribute("name", session.getAttribute("nameToShow"));
		model.addAttribute("hobby", session.getAttribute("hobbyToShow"));
		model.addAttribute("thing", session.getAttribute("thingToShow"));
		model.addAttribute("something", session.getAttribute("somethingniceToShow"));
	        
	    return "show";
	}
};