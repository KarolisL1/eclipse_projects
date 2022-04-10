package com.codingdojo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class Counter
{
	@GetMapping("")
	public String index(HttpSession session, Model model)
	{
		if(session.getAttribute("countToShow") == null) {
			session.setAttribute("countToShow", 0);
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("countToShow");
			currentCount += 1;
			session.setAttribute("countToShow", currentCount);
		}
		return "index";
	}
	
	@GetMapping("/showcounter")
	public String show(HttpSession session)
	{
		session.getAttribute("currentCount");
		return "show";
	}
	
	public String reset(HttpSession session) {
		session.setAttribute("countToShow", 0);
		return "index";
	}
	
};