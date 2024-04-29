package com.vistal.tech.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vistal.tech.entity.Signup;
import com.vistal.tech.service.SignupServiceImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/**
	 * Who will call this methid ???? spring security
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SignupServiceImpl signupServiceImpl;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if("yadna01".equals(username)) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			//yadna01- >> test ,ADMIN =>> all these things will come from database
			return new User("yadna01",passwordEncoder.encode("test"),authorities);
		}else if("jack".equals(username)) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("CUSTOMER"));
			//yadna01- >> test ,ADMIN =>> all these things will come from database
			return new User("jack",passwordEncoder.encode("jill"),authorities);
		}
		Optional<Signup>  optional=signupServiceImpl.findByEmailOrUsername(username);
		if (optional.isPresent()) {
			Signup signup=optional.get();
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			//yadna01- >> test ,ADMIN =>> all these things will come from database
			return new User(username,signup.getPassword(),authorities);
			
		}else {
				throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
	}

}