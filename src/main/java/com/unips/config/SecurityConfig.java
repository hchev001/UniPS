package com.unips.config;

import org.mockito.internal.matchers.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.unips.service.AuthenticationService;

@Configuration
@ComponentScan("com.unips")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	AuthenticationService authenticationService;
	

	protected void Configure (HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/static**").hasAnyRole("ADMIN", "USER", "BUSINESS")
		.and().formLogin();	
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            ShaPasswordEncoder encoder = new ShaPasswordEncoder();
            auth.userDetailsService(authenticationService).passwordEncoder(encoder);
	}
}
