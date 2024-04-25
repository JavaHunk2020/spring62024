package com.vistal.tech.rest;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vistal.tech.dto.ApplicationMessageDTO;
import com.vistal.tech.dto.PasswordChangeDTO;
import com.vistal.tech.entity.Signup;
import com.vistal.tech.service.PasswordResetService;
import com.vistal.tech.service.SignupServiceImpl;
import com.vistal.tech.utils.HelperUtils;

@RestController
@RequestMapping("/v5")
public class ForgotPasswordRestController {

	@Autowired
	private PasswordResetService passwordResetService;
	
	@Autowired
	private SignupServiceImpl signupServiceImpl;
	
	@PutMapping("/forgotPassword")
     public ApplicationMessageDTO updatePasswordPost(@RequestBody PasswordChangeDTO passwordChangeDTO)  {
		Optional<Signup> optional =signupServiceImpl.findByEmailOrUsername(passwordChangeDTO.getUsernameEmail());
		String code="C200";
		String message="Password is updated successfully";
		if(optional.isPresent()) {
			if(!passwordChangeDTO.getNewPassword().equalsIgnoreCase(passwordChangeDTO.getConfirmPassword())) {
				code ="C300";
				message="New password and confirm password are not same";
			}else {
				signupServiceImpl.updatePasswordByEmailOrUsername(passwordChangeDTO);
			}
		}else {
			code ="C400";
			message="Password could not be updated";
		}
		ApplicationMessageDTO applicationMessageDTO=new ApplicationMessageDTO(code,message);
 		return applicationMessageDTO;
	}
	
	@PostMapping("/forgotPassword")
	public ApplicationMessageDTO forgotPasswordPost(@RequestParam String unameEmail,HttpServletRequest httpServletRequest)  {
		String urlPattern=passwordResetService.validateAndGenLink(unameEmail);
		String baseURI=HelperUtils.getBaseURI(httpServletRequest);
		baseURI=baseURI+"/"+urlPattern;
		System.out.println("finalUrl = "+baseURI);
        ApplicationMessageDTO applicationMessageDTO=new ApplicationMessageDTO("C0194","Password reset link has been sent to your email id.");
 		return applicationMessageDTO;
	}
	
	@GetMapping("/validate/code/{unameEmail}/{code}")
	public ApplicationMessageDTO validateCodePost(@PathVariable  String unameEmail,@PathVariable String code)  {
		boolean status=passwordResetService.validateCodeAndUsername(code,unameEmail);
        ApplicationMessageDTO applicationMessageDTO=new ApplicationMessageDTO(status?"200":"600","Code is validated.");
 		return applicationMessageDTO;
	}
}
