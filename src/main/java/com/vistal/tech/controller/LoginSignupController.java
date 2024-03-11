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

import com.vistal.tech.dto.SignupDTO;
import com.vistal.tech.repository.SignRepository;
import com.vistal.tech.service.SignupServiceImpl;

@Controller
public class LoginSignupController {
	
	
	@Autowired
	private SignupServiceImpl signupServiceImpl;
	
	@GetMapping("sortByAttribute")
	public String sortByName(String orderBy,String attributeName, Model model) {
		List<SignupDTO> signups=signupServiceImpl.findAllOrderBy(attributeName, orderBy);
		model.addAttribute("signups",signups);
		return "home";
	}
	
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
		List<SignupDTO> signups=signupServiceImpl.findAll();
		model.addAttribute("signups",signups);
		return "home";
	}
	
	@GetMapping("deleteSignup")
	public String showLogin(@RequestParam String uname, Model model) {
		signupServiceImpl.deleteByUsername(uname);
		return "redirect:/signups";
	}
	
	@PostMapping("/auth")
	public String authPost(@RequestParam String username,@RequestParam String password,HttpSession session, Model model) {
		Optional<SignupDTO> optional=signupServiceImpl.findByUsername(username);
		if(optional.isEmpty() || !password.equals(optional.get().getPassword())) {
			model.addAttribute("message","Hmmm your username and password are not correct.");
			return "login";
		}else {
			if(optional.isPresent()) {
				SignupDTO signup=optional.get();
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
	public String postSignup(@ModelAttribute SignupDTO signup , Model model) {
		System.out.println(signup);
		signupServiceImpl.saveData(signup);
		model.addAttribute("message","You have registered successfully.");
		return "signup";
	}
	

}
