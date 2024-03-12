package com.vistal.tech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vistal.tech.entity.Signup;

@Repository
public interface SignRepository extends JpaRepository<Signup, String> {
	
	public List<Signup> findAllByOrderByUsernameAsc();
	public List<Signup> findAllByOrderByUsernameDesc();
	public List<Signup> findAllByOrderByEmailAsc();
	public List<Signup> findAllByOrderByEmailDesc();
	
	//HQL
	@Query("from Signup s order by s.email desc")
	public List<Signup> findWow();
	
	public Optional<Signup> findByEmailOrUsername(String email,String username);

}
