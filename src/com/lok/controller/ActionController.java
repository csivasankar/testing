package com.lok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lok.model.User;
import com.lok.service.UserService;

@Controller
public class ActionController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String sayHello(){
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getRegisterPage(){
		return "register";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String checkLogin(@RequestParam("uname") String uname,
				@RequestParam("password") String pwd, Model model){
		if(uname.equals("lokesh")&&pwd.equals("lokesh")){
			model.addAttribute("message", "Hi...." + uname);
			return "welcome";
		}
		model.addAttribute("error_msg","Wrong Username or Password");
		return "login";
	}
	

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerMe(User user ,Model model){
		if(user.getName().equals("") || user.getUserName().equals("") ||
		   user.getPassword().equals("") || user.getEmail().equals("") ||
		   user.getLocation().equals("")){
			model.addAttribute("message", "fill all fields...");
			return "register";
		}
		userService.saveUser(user);
		model.addAttribute("message", "Hi....."+user.getName()+"You have registered successfully...");
		return "welcome";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateUser(User user, Model model){
		userService.updateUser(user);
		model.addAttribute("message", "Hi....."+user.getName()+"Your data updated successfully...");
		return "welcome";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteUser(User user, Model model){
		userService.deleteUser(user);
		model.addAttribute("message", user.getName()+" deleted successfully...");
		return "list";
	}
	
	/*@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@RequestParam("name") String name,@RequestParam("userName") String uName,
			@RequestParam("password") String pwd,@RequestParam("email") String eMail,
			@RequestParam("location") String location, Model model){
		
		User user = new User();
		user.setName(name);
		user.setUserName(uName);
		user.setPassword(pwd);
		user.setEmail(eMail);
		user.setLocation(location);
		
		userService.saveUser(user);
		model.addAttribute("message", "Hi...." + name+". You have registered successfully...");
		return "welcome";
	}*/
	
	
	/*@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateUser(@RequestParam("name") String name,@RequestParam("uname") String uName,
			@RequestParam("password") String pwd,@RequestParam("email") String eMail,
			@RequestParam("location") String location, Model model){
		
		User user = new User();
		user.setName(name);
		user.setUserName(uName);
		user.setPassword(pwd);
		user.setEmail(eMail);
		user.setLocation(location);
		
		userService.updateUser(user);
		return "welcome";
	}*/
	
	
	@RequestMapping("/welcome")
	public String sayWelcome(@RequestParam("name") String name, Model model){
		String msg = "Hi...." + name;
		System.out.println("Name : " + name);
		model.addAttribute("message", msg);
		return "welcome";
	}
}
