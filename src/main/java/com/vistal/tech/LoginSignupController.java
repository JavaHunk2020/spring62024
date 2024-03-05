package com.vistal.tech;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("deleteSignup")
	public String showLogin(@RequestParam String uname, Model model) {
		DataStore.deleteData(uname);
		model.addAttribute("message","Data is deleted successfully!.");
		return "home";
	}
	
	@PostMapping("/auth")
	public String authPost(@RequestParam String username,@RequestParam String password, Model model) {
		SignupDTO signupDTO=DataStore.get(username);
		if(signupDTO==null || !password.equals(signupDTO.getPassword())) {
			model.addAttribute("message","Hmmm your username and password are not correct.");
			return "login";
		}else {
			return "home";
		}
	}
	
	@GetMapping("/signup")
	public String showPage() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute SignupDTO signupDTO , Model model) {
		System.out.println(signupDTO);
		DataStore.put(signupDTO);
		model.addAttribute("message","You have registered successfully.");
		return "signup";
	}
	

}
