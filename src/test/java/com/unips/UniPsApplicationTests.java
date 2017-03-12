package com.unips;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class UniPsApplicationTests {

	// Match everything without a suffix (so not a static resource)
	@RequestMapping(value = "/")
	public String home() {
		return "/";
	}
	
	public static void main(String[] args) {
		
		new SpringApplicationBuilder(UniPsApplicationTests.class)
			.properties("server.port=9999").run(args);
	}
	
	@Configuration
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {	
			http.authorizeRequests().antMatchers("/*").permitAll();

		}
	}
}
