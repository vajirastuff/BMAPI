package com.mart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mart.db.model.User;
import com.mart.service.UserService;
import com.mart.uri.UserURIConstants;
//@Controller annotation, so that Spring framework will treat it as a Controller class to handle client requests
@Controller
public class UserController {

	private UserService userService;
	
	// @Autowired and @Qualifier annotations for injecting UserService
	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listusers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listusers", this.userService.listUsers());
		return "users";
	}
	
	@RequestMapping(value = UserURIConstants.GET_ALL_USER, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers(){
		List<User> list = userService.listUsers();
		return list;
		
	}

	// For add and update user both
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User u) {

		if (u.getId() == 0) {
			// new user, add it
			this.userService.addUser(u);
		} else {
			// existing user, call update
			this.userService.updateUser(u);
		}

		return "redirect:/users";

	}

	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {

		this.userService.removeUser(id);
		return "redirect:/users";
	}

	@RequestMapping("/edit/{id}")
	public String editUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userService.getUserById(id));
		model.addAttribute("listusers", this.userService.listUsers());
		return "users";
	}

}
