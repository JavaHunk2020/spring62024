package com.vistal.tech.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vistal.tech.dto.SignupDTO;
import com.vistal.tech.entity.Signup;
import com.vistal.tech.repository.ResetPasswordHistoryRepository;
import com.vistal.tech.repository.SignRepository;

@Service
public class SignupServiceImpl {

	@Autowired
	private SignRepository signRepository;
	
	
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
			throw new RuntimeException("Sorry username does not exist into the database");
		}
	}
	
	public void saveData(SignupDTO signupDTO ) {
		Signup signup = new Signup();
		BeanUtils.copyProperties(signupDTO, signup);
		signRepository.save(signup);
	}
	
	public void deleteByUsername(String uname) {
		signRepository.deleteById(uname);	
	}
	
}
