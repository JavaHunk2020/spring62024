package com.vistal.tech.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class SpringSecurityConfiguration  {


	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}


	@Bean
    public AuthenticationManager authenticationManager
        (AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration
                           .getAuthenticationManager();
    }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	  
	private String adminAccess[] = new String[]{"/v5/admin/**"};
	  
	 private static final String[] AUTH_WHITELIST = {
	            // -- swagger ui
				"/v2/api-docs", "/v3/api-docs", "/swagger-resources/**", "/webjars/**", "/swagger-ui/**", "/ui/**", "/v5/cauth/**", "/v5/signups/**","/swagger-ui.html/**" };

	@Bean
	protected SecurityFilterChain  filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
				.antMatchers(adminAccess).hasRole("ADMIN") //THIS ROLE BASED ACCESS FOR THIS URL
				.anyRequest().authenticated();
		return http.build();
	}
}