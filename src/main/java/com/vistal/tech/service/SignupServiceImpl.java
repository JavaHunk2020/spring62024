package com.vistal.tech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vistal.tech.dto.PasswordChangeDTO;
import com.vistal.tech.dto.PatchDTO;
import com.vistal.tech.dto.SignupDTO;
import com.vistal.tech.entity.Signup;
import com.vistal.tech.exception.SignupNotFoundException;
import com.vistal.tech.repository.SignRepository;

@Service
public class SignupServiceImpl {

	@Autowired
	private SignRepository signRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AopMagicService aopMagicService;
	
	@PostConstruct
	public void init() throws InterruptedException {
		aopMagicService.sec10();
		aopMagicService.sec2();
	}
	
    @Transactional
	public void updatePasswordByEmailOrUsername(PasswordChangeDTO passwordChangeDTO){
    	Optional<Signup>  sOptional= signRepository.findByEmailOrUsername(passwordChangeDTO.getUsernameEmail(), passwordChangeDTO.getUsernameEmail());
    	if(sOptional.isPresent()) {
    		Signup signup=sOptional.get();
    		signup.setPassword(passwordEncoder.encode(passwordChangeDTO.getNewPassword()));
    	}
	}
	
	public Optional<Signup> findByEmailOrUsername(String emailOrUsername){
		return signRepository.findByEmailOrUsername(emailOrUsername, emailOrUsername);
	}
	
	public List<SignupDTO> findAllOrderBy(String attribute,String orderBy) {
		List<Signup> signups=new ArrayList<>();
		if ("username".equals(attribute)) {
			if ("asc".equalsIgnoreCase(orderBy)) {
				signups = signRepository.findAllByOrderByUsernameAsc();
			} else {
				signups = signRepository.findAllByOrderByUsernameDesc();
			}
		} else if ("email".equals(attribute)) {
			if ("asc".equalsIgnoreCase(orderBy)) {
				signups = signRepository.findAllByOrderByEmailAsc();
			} else {
				signups = signRepository.findAllByOrderByEmailDesc();
			}
		}
		List<SignupDTO> dtos = new ArrayList<>();
		for (Signup signup : signups) {
			SignupDTO dto = new SignupDTO();
			BeanUtils.copyProperties(signup, dto);
			dtos.add(dto);
		}
		return dtos;
	}
	

	public List<SignupDTO> findAll() {
		List<Signup> signups = signRepository.findAll();
		List<SignupDTO> dtos = new ArrayList<>();
		for (Signup signup : signups) {
			SignupDTO dto = new SignupDTO();
			BeanUtils.copyProperties(signup, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	public List<SignupDTO> findAllJava8() {
		return signRepository.findAll().stream().map(s -> {
			SignupDTO dto = new SignupDTO();
			BeanUtils.copyProperties(s, dto);
			return dto;
		}).collect(Collectors.toList());
	}
	
	public Optional<SignupDTO> findByUsername(String username) {
		Optional<Signup> optional = signRepository.findById(username);
		if (optional.isPresent()) {
			SignupDTO signupDTO = new SignupDTO();
			Signup signup = optional.get();
			BeanUtils.copyProperties(signup, signupDTO);
			return Optional.of(signupDTO);
		} else {
			throw new SignupNotFoundException("Sorry username does not exist into the database");
		}
	}
	
	public void updateData(SignupDTO signupDTO ) {
		Optional<Signup> optional = signRepository.findById(signupDTO.getUsername());
		if(optional.isPresent()) {
			Signup signup = optional.get();
			signup.setEmail(signupDTO.getEmail());
			signup.setGender(signupDTO.getGender());
			signRepository.save(signup);
		}
	}
	
	@Transactional
	public void uupdateData(SignupDTO signupDTO ) {
		Optional<Signup> optional = signRepository.findById(signupDTO.getUsername());
		if(optional.isPresent()) {
			Signup signup = optional.get();
			signup.setEmail(signupDTO.getEmail());
			signup.setGender(signupDTO.getGender());
		}
	}
	
	public void saveData(SignupDTO signupDTO ) {
		Signup signup = new Signup();
		BeanUtils.copyProperties(signupDTO, signup);
		String encodedPassword=passwordEncoder.encode(signupDTO.getPassword());
		signup.setPassword(encodedPassword);
		signRepository.save(signup);
		//Calling Microservices
		
	}
	
	public void deleteByUsername(String uname) {
		signRepository.deleteById(uname);	
	}
	
	
	@Transactional
	public void updateData(PatchDTO patchDTO ) {
		Optional<Signup> optional = signRepository.findById(patchDTO.getKey());
		if(optional.isPresent()) {
			Signup signup = optional.get();
			if("email".equalsIgnoreCase(patchDTO.getAttributeName())) {
				signup.setEmail(patchDTO.getValue());
			}else if("gender".equalsIgnoreCase(patchDTO.getAttributeName())) {
				signup.setGender(patchDTO.getValue());
			}else {
				new RuntimeException("Sorry there is not attribute  = "+patchDTO.getAttributeName());
			}
		}
	}
	
}
