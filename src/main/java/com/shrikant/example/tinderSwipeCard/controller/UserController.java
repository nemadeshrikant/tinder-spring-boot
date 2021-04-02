package com.shrikant.example.tinderSwipeCard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shrikant.example.tinderSwipeCard.model.User;
import com.shrikant.example.tinderSwipeCard.repo.UserRepository;

import com.shrikant.example.tinderSwipeCard.service.UserService;

@Controller
public class UserController 
{
	public String tempusername="";
	
	@Autowired
	UserService userv;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/userhome")
	public String userhome()
	{
		
		
		return "userhome";
	}
	
	@RequestMapping("/signup")
	public String getSignup()
	{
		return "signup";
	}
	
	@RequestMapping("/login")
	public String getLogin()
	{
		return "login";
	}
	
	@PostMapping("/addUser")
	public ModelAndView addUser(@RequestParam("user_email") String user_email, User user)
	{
		ModelAndView mv=new ModelAndView("login");
	
		
		userv.saveOrUpdate(user);
		mv.addObject("message","User has been successfully registered.");
	
	return mv;
	}
		
		
	
	@GetMapping("/dummy")
	public String dummy()
	{
		return "dummy";
	}
	
	/*@PostMapping("/login")
	public String login_user(@RequestParam("username") String username,@RequestParam("password") String password,
			HttpSession session,ModelMap modelMap)
	{
		
	User auser=userv.findByUsernamePassword(username, password);
	
	if(auser!=null)
	{
		String uname=auser.getUser_email();
		String upass=auser.getUser_pass();
	
		if(username.equalsIgnoreCase(uname) && password.equalsIgnoreCase(upass)) 
		{
			session.setAttribute("username",username);
			tempusername=username;
			ModelAndView msv=new ModelAndView("/userhome");
			return "/userhome";
		}
		else 
		{
			modelMap.put("error", "Invalid Account");
			return "login";
		}
	}
	else
	{
		modelMap.put("error", "Invalid Account");
		return "login";
	}
	
	}*/
	
	@GetMapping(value = "/logout")
	public String logout_user(HttpSession session)
	{
		session.removeAttribute("username");
		session.invalidate();
		return "redirect:/login";
	}
	
	
	@PostMapping("/userhome")
	public String userhome(Model model)
	{
		model.addAttribute("username", tempusername);
		
		return "userhome";
	}
	
	
}
