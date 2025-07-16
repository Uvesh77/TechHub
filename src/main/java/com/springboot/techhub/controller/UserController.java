package com.springboot.techhub.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.techhub.dto.Users_Master_Dto;
import com.springboot.techhub.service.Order_Master_Service;
import com.springboot.techhub.service.Users_Master_Service;


@Controller
public class UserController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private Users_Master_Service service;

	@Autowired
	private Order_Master_Service order_Master_Service;

	// @Autowired
	// private Category_Master_Repository category_Master_Repository;
	
	@GetMapping("/register")
	public String getRegistrationPage(@ModelAttribute("user")Users_Master_Dto master_Dto) {
		return "register";
	}
	
	@PostMapping("/register")
	public String saveUsers(@ModelAttribute("user")Users_Master_Dto master_Dto,Model model ){
		service.save(master_Dto);
		model.addAttribute("message", "Registered Successfuly !");
		return "register";
	}
	
	@GetMapping("/loginf")
	public String getLoginPage() {
		return "loginf";
	}
	
	@GetMapping("/admin")
	public String getAdminPage(Model model,Principal principal) {
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user_Master", userDetails);
		model.addAttribute("order_details", order_Master_Service.GetAllOrderDetails());
		return "admin";
	}
}
