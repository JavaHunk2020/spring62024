package com.vistal.tech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vistal.tech.entity.Signup;
import com.vistal.tech.repository.SignRepository;
import com.vistal.tech.utils.HelperUtils;

@Service
public class PasswordResetService {
	
	@Autowired
	private SignRepository signRepository;
	
	public String validateAndGenLink(String username) {
		
		Optional<Signup>  optional=signRepository.findByEmailOrUsername(username, username);
		if(optional.isPresent()) {
			return "http://localhost:444/resetPassword?email="+username+"&code="+HelperUtils.generateRandomCode(6);
		}
		throw new RuntimeException("username/email not found");
	}

}
