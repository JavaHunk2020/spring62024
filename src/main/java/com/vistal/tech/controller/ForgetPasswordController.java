package com.vistal.tech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vistal.tech.service.PasswordResetService;
import com.vistal.tech.utils.HelperUtils;

@Controller
@Scope("singleton")
public class ForgetPasswordController {
	
	@Autowired
	private PasswordResetService passwordResetService;
	
	@GetMapping("/forgetPassword")
	public String showForgetPassword() {
		return "forgetPassword";
	}
	
	//    <input type="text" name="username" class="form-control" style="width: 40%">
	@PostMapping("/forgetPassword")
	public String postForgetPassword(String username,Model model,HttpServletRequest httpServletRequest) {
		String urlPattern=passwordResetService.validateAndGenLink(username);
		String baseURI=HelperUtils.getBaseURI(httpServletRequest);
		baseURI=baseURI+"/"+urlPattern;
		System.out.println("finalUrl = "+baseURI);
		model.addAttribute("message","Password reset link has been sent to your email id.");
		return "forgetPassword";
	}

}
