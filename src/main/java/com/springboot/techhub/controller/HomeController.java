package com.springboot.techhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String gethomePage() {
		return "Home";
	}

	// @GetMapping("/contact")
	// public String getContactPage(){
	// 	return "contact";
	// }
}
