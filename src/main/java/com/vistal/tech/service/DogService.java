package com.vistal.tech.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.vistal.tech.dto.DogDTO;
import com.vistal.tech.dto.EmailDTO;

@Service
public class DogService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${email.service.url}")
	private String emailServiceNameURL;
	
	/**
	 * @GetMapping("platform/dogs")
	   public List<DogDTO> findDetails() {
	   }
	 * @return
	 * @throws URISyntaxException
	 */

	public List<DogDTO> findDogs() {
		// http://EMAIL-MICROSERVICE/platform/emails
		final String uri =emailServiceNameURL + "/platform/dogs";
		//I AM TRYING TO FETCH LIST OF DATA  - List<DogDTO>
		ResponseEntity<List<DogDTO>> dogResponseEntity = 
				restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<DogDTO>>() {
				});
		System.out.println("Status code = " + dogResponseEntity.getStatusCodeValue());
		return dogResponseEntity.getBody();
	}

}
