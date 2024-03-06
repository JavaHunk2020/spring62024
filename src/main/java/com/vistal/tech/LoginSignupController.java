package com.vistal.tech;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginSignupController {
	
	@Autowired
	private SignRepository signRepository;
	
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
		signRepository.deleteById(uname);
		model.addAttribute("message","Data is deleted successfully!.");
		List<Signup> signups=signRepository.findAll();
		model.addAttribute("signups",signups);
		return "home";
	}
	
	@PostMapping("/auth")
	public String authPost(@RequestParam String username,@RequestParam String password, Model model) {
		Optional<Signup> optional=signRepository.findById(username);
		if(optional.isPresent() && !password.equals(optional.get().getPassword())) {
			model.addAttribute("message","Hmmm your username and password are not correct.");
			return "login";
		}else {
			List<Signup> signups=signRepository.findAll();
			model.addAttribute("signups",signups);
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
		Signup signup=new Signup();
		BeanUtils.copyProperties(signupDTO, signup);
		signRepository.save(signup);
		model.addAttribute("message","You have registered successfully.");
		return "signup";
	}
	

}
