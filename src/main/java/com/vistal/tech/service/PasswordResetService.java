package com.vistal.tech.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vistal.tech.entity.ResetPasswordHistory;
import com.vistal.tech.entity.Signup;
import com.vistal.tech.repository.ResetPasswordHistoryRepository;
import com.vistal.tech.repository.SignRepository;
import com.vistal.tech.utils.HelperUtils;

@Service
public class PasswordResetService {
	
	@Autowired
	private SignRepository signRepository;
	
	@Autowired
	private ResetPasswordHistoryRepository resetPasswordHistoryRepository;
	
	public String validateAndGenLink(String username) {
		
		Optional<Signup>  optional=signRepository.findByEmailOrUsername(username, username);
		if(optional.isPresent()) {
			//Saving link into database
			ResetPasswordHistory history=new ResetPasswordHistory();
			String code=HelperUtils.generateRandomCode(6);
			history.setCode(code);
			Timestamp timestamp=new Timestamp(new Date().getTime());
			history.setCreateDate(timestamp);
			history.setNotes("Reset password");
			history.setSignup(optional.get());
			history.setLinkexpOn(timestamp);
			history.setStatus("No");
			Timestamp expOn=new Timestamp(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(20)).getTime());
			history.setLinkexpOn(expOn);
			Optional<ResetPasswordHistory> optionalPassword=resetPasswordHistoryRepository.findRecordByUsername(username);
			if(optionalPassword.isPresent()) {
				ResetPasswordHistory dbPasswordHistory=optionalPassword.get();
				dbPasswordHistory.setCode(code);
				dbPasswordHistory.setLinkexpOn(expOn);
				dbPasswordHistory.setCreateDate(timestamp);
			    resetPasswordHistoryRepository.save(dbPasswordHistory);
			}else {
			   resetPasswordHistoryRepository.save(history);
			}
			return "resetPassword?email="+username+"&code="+code;
		}
		throw new RuntimeException("username/email not found");
	}

}
