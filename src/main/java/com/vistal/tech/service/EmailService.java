package com.vistal.tech.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vistal.tech.dto.EmailDTO;

@Service
public class EmailService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Value("${email.service.url}")
	private String emailServiceNameURL;
	
	/**
	 * @PostMapping("platform/emails")
	public Map<String,Object> sendEmail(@RequestBody EmailDTO emailDTO){
		emailService.send(emailDTO);
		return Map.of("message","email is send successfully","code","EM1092");
	}
	 * @param email
	 * @throws URISyntaxException
	 */
	
	public void sendSignupEmail(String email) throws URISyntaxException {
		//http://EMAIL-MICROSERVICE/platform/emails
		URI uri = new URI(emailServiceNameURL+"/platform/emails");
		EmailDTO emailDTO =new EmailDTO();
		emailDTO.setToEmails(List.of(email));
		emailDTO.setType("signup");
		//HERE USING REST TEMPLATE WE ARE CALLING EMAIL-SERVICE - REST API
		// METHOD = POST
		//URI =
		//Request Payload
		//Response Payload
		ResponseEntity<Map> result = restTemplate.postForEntity(uri, emailDTO, Map.class);
		System.out.println(result.getBody());
	}
	
	
	

}
