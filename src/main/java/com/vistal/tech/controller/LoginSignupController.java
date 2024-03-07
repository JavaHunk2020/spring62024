package com.vistal.tech.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vistal.tech.entity.Signup;
import com.vistal.tech.repository.SignRepository;

@Controller
public class LoginSignupController {
	
	@Autowired
	private SignRepository signRepository;
	
	@GetMapping({"/papaya","/","fool","login","auth"})
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(Model model,HttpSession session){
		session.invalidate();
		model.addAttribute("message","You have successfully logout!.");
		return "login";
	}
	
	
	@GetMapping("/signups")
	public String findSigups(Model model){
		List<Signup> signups=signRepository.findAll();
		model.addAttribute("signups",signups);
		return "home";
	}
	
	@GetMapping("deleteSignup")
	public String showLogin(@RequestParam String uname, Model model) {
		signRepository.deleteById(uname);
		return "redirect:/signups";
	}
	
	@PostMapping("/auth")
	public String authPost(@RequestParam String username,@RequestParam String password,HttpSession session, Model model) {
		Optional<Signup> optional=signRepository.findById(username);
		if(optional.isEmpty() || !password.equals(optional.get().getPassword())) {
			model.addAttribute("message","Hmmm your username and password are not correct.");
			return "login";
		}else {
			if(optional.isPresent()) {
				Signup signup=optional.get();
				signup.setPassword("");
				session.setAttribute("ssignup", signup);
			}
			return "redirect:/signups";
		}
	}
	
	@GetMapping("/signup")
	public String showPage() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute Signup signup , Model model) {
		System.out.println(signup);
		signRepository.save(signup);
		model.addAttribute("message","You have registered successfully.");
		return "signup";
	}
	

}
