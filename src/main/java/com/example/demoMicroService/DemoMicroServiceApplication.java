package com.example.demoMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
*/import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient;

@EnableEurekaClient
@SpringBootApplication
public class DemoMicroServiceApplication {
	@LoadBalanced
	@Bean
	// creating rest template bean as it is singleton and save multiple calls
	public RestTemplate rest() {
		return new RestTemplate();
	}

	@Bean
	public WebClient.Builder wb() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoMicroServiceApplication.class, args);
	}

	/*  *//**
			 * The default Spring logout behavior redirects a user back to
			 * {code}/login?logout{code}, so you will likely want to change that. The
			 * easiest way to do this is by extending from
			 * {@link WebSecurityConfigurerAdapter}.
			 *//*
				 * @Configuration static class WebConfig extends WebSecurityConfigurerAdapter {
				 * 
				 * @Override protected void configure(HttpSecurity http) throws Exception {
				 * http.authorizeRequests() // allow antonymous access to the root page
				 * .antMatchers("/").permitAll() // all other requests
				 * .anyRequest().authenticated()
				 * 
				 * // set logout URL .and().logout().logoutSuccessUrl("/")
				 * 
				 * // enable OAuth2/OIDC .and().oauth2Client() .and().oauth2Login(); } }
				 */

}
