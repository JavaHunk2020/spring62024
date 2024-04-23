package com.vistal.tech.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vistal.tech.dto.ApplicationMessageDTO;
import com.vistal.tech.service.PasswordResetService;
import com.vistal.tech.utils.HelperUtils;

@RestController
@RequestMapping("/v5")
public class ForgotPasswordRestController {

	@Autowired
	private PasswordResetService passwordResetService;
	
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
