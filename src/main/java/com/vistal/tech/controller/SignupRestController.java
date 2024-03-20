package com.vistal.tech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vistal.tech.dto.SignupDTO;
import com.vistal.tech.service.SignupServiceImpl;

@RestController
@RequestMapping("/v5")
public class SignupRestController {
	
	@Autowired
	private SignupServiceImpl signupServiceImpl;
	
	//URI - > URL
	//http://localhost:444/v5/signups
	@GetMapping("/signups")
	public List<SignupDTO> showSignups() {
    	List<SignupDTO> signups=signupServiceImpl.findAll();
		return signups;
	}
	
	//http://localhost:444/v5/signups/12
	@GetMapping("/signups/{username}")
	public SignupDTO showSignup(@PathVariable String username) {
		Optional<SignupDTO> sOptional=signupServiceImpl.findByUsername(username);
		return sOptional.get();
	}

}
