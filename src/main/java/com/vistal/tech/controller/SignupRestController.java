package com.vistal.tech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vistal.tech.dto.ApplicationMessageDTO;
import com.vistal.tech.dto.PatchDTO;
import com.vistal.tech.dto.SignupDTO;
import com.vistal.tech.service.SignupServiceImpl;

@RestController
@RequestMapping("/v5")
public class SignupRestController {
	
	@Autowired
	private SignupServiceImpl signupServiceImpl;
	
	//IDEMPOTENT = DELETE, PUT and GET
	//NON IDEMPOTENT = POST and PATCH
	//URI - > URL
	//http://localhost:444/v5/signups
	//Every method is called resource
	@GetMapping("/signups")
	public List<SignupDTO> showSignups() {
    	List<SignupDTO> signups=signupServiceImpl.findAll();
		return signups;
	}
	
	//http://localhost:444/v5/signups/yadna01
	@GetMapping("/signups/{username}")
	public SignupDTO showSignup(@PathVariable String username) {
		Optional<SignupDTO> sOptional=signupServiceImpl.findByUsername(username);
		return sOptional.get();
	}
	
	//{}  =>> sending data as part URI
	@DeleteMapping("/signups/{username}")
	public ApplicationMessageDTO deleteSignup(@PathVariable String username) {
		signupServiceImpl.deleteByUsername(username);
		ApplicationMessageDTO applicationMessageDTO=new ApplicationMessageDTO("C0192","resource is deleted");
		return applicationMessageDTO;
	}
   
	//{} JSON=> @RequestBody ->>> java object
	@PostMapping("/signups")
	public ApplicationMessageDTO createSignup(@RequestBody SignupDTO signupDTO) {
        signupServiceImpl.saveData(signupDTO);
        ApplicationMessageDTO applicationMessageDTO=new ApplicationMessageDTO("C0194","resource is created");
 		return applicationMessageDTO;
	}
	
	@PutMapping("/signups")
	public ApplicationMessageDTO updateSignup(@RequestBody SignupDTO signupDTO) {
        signupServiceImpl.uupdateData(signupDTO);
        ApplicationMessageDTO applicationMessageDTO=new ApplicationMessageDTO("C0194","resource is updated");
 		return applicationMessageDTO;
	}
	
	@PatchMapping("/signups")
	public ApplicationMessageDTO patchSignup(@RequestBody PatchDTO patchDTO) {
        signupServiceImpl.updateData(patchDTO);
        ApplicationMessageDTO applicationMessageDTO=new ApplicationMessageDTO("C0196","resource is updated");
 		return applicationMessageDTO;
	}
}
