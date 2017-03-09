package com.unips.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.unips.service.AuthenticationService;

@Configuration
@ComponentScan("com.unips")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected void Configure (HttpSecurity http) throws Exception {
		
		http
			.httpBasic().and()
			.authorizeRequests()
				.antMatchers("/index.html", "/", "/login", "/message", "/home").permitAll()
				.anyRequest().authenticated()
				.and()
		.csrf()
			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            ShaPasswordEncoder encoder = new ShaPasswordEncoder();
            auth.userDetailsService(authenticationService).passwordEncoder(encoder);
	}
}
