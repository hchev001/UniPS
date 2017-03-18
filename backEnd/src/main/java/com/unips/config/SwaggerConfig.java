package com.unips.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan("com.unips.config")
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		// @formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/api/**"))
				.build();
		// @formatter:on
	}
	
	private ApiInfo getInfo() {
		
		// @formatter:off
		 return new ApiInfoBuilder()
				 .title("UniPS API")
				 .description("REST API for the University Premier Services.")
				 .contact(new Contact("UniPS", "Unips.com", "unipsi2017@gmail.com"))
				 .version("1.0.0")
				 .build();
		// @formatter:on

	}
}
