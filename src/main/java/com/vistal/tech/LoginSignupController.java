package com.vistal.tech;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginSignupController {
	
	public LoginSignupController() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@");
		
	}
	
	@GetMapping({"/papaya","/","fool","login","auth"})
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String showPage() {
		return "signup";
	}

}
