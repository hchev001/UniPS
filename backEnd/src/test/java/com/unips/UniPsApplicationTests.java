package com.unips;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@Configuration()
public class UniPsApplicationTests {

	public static void main(String[] args) {
		
		SpringApplicationBuilder ab = new SpringApplicationBuilder(UniPsApplicationTests.class);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("server.port", 9999);
		properties.put("security.basic.enabled", false);
		properties.put("security.enable-csrf", false);
		
		ab.properties(properties);
		ab.run(args);
	}
	
	@Configuration
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {	
			http.httpBasic().disable();
			http.authorizeRequests().antMatchers("/**").permitAll();
		}
	}
}
