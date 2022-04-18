package com.codingdojo.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	public HomeController(UserService userService) {
		this.userService = userService;
	};
	
	@GetMapping("/")
	public String user_register_get(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index";
	}
	
//	@GetMapping("/")
//	public String index(HttpSession session) {
//		if(!userService.isLoggedIn(session)) return "redirect:/register";
//		return "index";
//	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		userService.Logout(session);
		return "redirect:/";
	}
	
	@PostMapping("/register")
	public String user_register_post(
			@Valid @ModelAttribute("user") User user,
	        BindingResult result,
	        Model model,
	        HttpSession session
			) 
	{
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index";
		}
		User created_user = userService.register(user, result);
		if(created_user == null) return "index";
		return "redirect:/";
	}
	
//	@GetMapping("/login")
//	public String user_login_get(Model model)
//	{
//		model.addAttribute("user",new LoginUser());
//		return "user_login";
//	}
	
	@PostMapping("/login")
	public String user_login_post
	(
		@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
        BindingResult result,
        Model model,
        HttpSession session	
	)
	{
		if(result.hasErrors()) {
			model.addAttribute("user", new User());
			return "index";
		}
		User db_user=userService.login(newLogin,result);
		if(db_user == null) return "index";
		session.setAttribute("user_id", db_user.getId());
		session.setAttribute("user", db_user.getName());
		return "redirect:/books";
	}
	
	
}
