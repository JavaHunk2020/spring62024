package com.vistal.tech.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
import com.vistal.tech.security.JwtUtils;
import com.vistal.tech.service.SignupServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v5")
@Api(value = "API Description SignupRestController") // it description of api at top
public class SignupRestController {
	
	@Autowired
	private SignupServiceImpl signupServiceImpl;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/cauth")
	public Map<String, Object> postLogin(@RequestBody SignupDTO signupRequest) {
		// authentication has two things - username and role
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signupRequest.getEmail(), signupRequest.getPassword()));
		String jwt = jwtUtils.generateJwtToken(authentication);
		Map<String, Object> jwtReponse = new HashMap<>();
		jwtReponse.put("Authorization", jwt);
		jwtReponse.put("email", signupRequest.getEmail());
		return jwtReponse;
	}
	
	//IDEMPOTENT = DELETE, PUT and GET
	//NON IDEMPOTENT = POST and PATCH
	//URI - > URL
	//http://localhost:444/v5/signups
	//Every method is called resource
	@GetMapping("/signups")
	@ApiOperation(value = "It will return list of SignupDTO")    
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
