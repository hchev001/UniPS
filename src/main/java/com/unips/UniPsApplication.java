package com.unips;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableAutoConfiguration
@Controller
public class UniPsApplication {

	// Match everything without a suffix (so not a static resource)
	@RequestMapping(value = "/{path:[^\\.]*}")
	public String redirect() {
		// Forward to home page so that route is preserved.
		return "forward:/";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(UniPsApplication.class, args);
	}
}
