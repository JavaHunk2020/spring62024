package com.vistal.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vistal.tech.entity.Signup;

@Repository
public interface SignRepository extends JpaRepository<Signup, String> {

}
