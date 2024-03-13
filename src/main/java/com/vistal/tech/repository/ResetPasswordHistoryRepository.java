package com.vistal.tech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vistal.tech.entity.ResetPasswordHistory;

@Repository
public interface ResetPasswordHistoryRepository extends JpaRepository<ResetPasswordHistory,Integer>{

	//HQL - Hibernate query language 
	@Query(value="from ResetPasswordHistory rph where rph.status='No' AND rph.signup.username = ?1")
	public Optional<ResetPasswordHistory> findRecordByUsername(String username);
}
