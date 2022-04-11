package com.codingdojo;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class NinjaGoldController
{

	@RequestMapping(value="/find", method=RequestMethod.POST)
	public String find(@RequestBody() String location, HttpSession session)
	{
		String place = location.substring(location.lastIndexOf("=")+1);
		System.out.println(place);
		Random rn = new Random();
		int gold = (int) session.getAttribute("gold");
		int answer= 0;
		String story = "";
		
		switch(place) {
			case "farm":
				answer = rn.nextInt(10) + 10;
				break;
			case "cave":
				answer = rn.nextInt(10) + 10;
				break;
			case "house":
				answer = rn.nextInt(10) + 10;
				break;
			case "quest":
				answer = rn.nextInt(100) - 50;
				break;		
		}
		
		gold += answer;
		session.setAttribute("gold", gold);	
		
		if (!place.equals("quest") ) {
			story = "You entered a " +place+ " and earned "+answer+"gold.";
		}else {
			if (answer > 0){
				story = "You completed a quest and earned "+Math.abs(answer)+" gold.";
			}else {
				story = "You failed a quest and lost "+answer+" gold. Ouch.";
			}
			System.out.println(answer);
		}
		
		ArrayList<String> stories=(ArrayList<String>)session.getAttribute("stories");
		stories.add(story);
		session.setAttribute("stories",stories);
		
		
//		if(place != null) {
//			int answer = rn.nextInt(10) + 1;
//			gold += answer;
//			System.out.println("%%%%" + gold + " "+ answer);
//			session.setAttribute("gold", gold);
//		}
		
		return "redirect:/gold";
	}
	
	
	@RequestMapping("/gold")
	public String index(Model model, HttpSession session)
	{
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("stories")==null)
		{
			session.setAttribute("stories",new ArrayList<String>());	
		}
		//model.addAttribute("gold", session.getAttribute("gold"));
		return "index";
	}
	@RequestMapping("/reset")
	public String reset(Model model, HttpSession session)
	{
		
//		session.setAttribute("gold", 0);
		session.invalidate();
		
		//model.addAttribute("gold", session.getAttribute("gold"));
		return "redirect:/gold";
	}
};
