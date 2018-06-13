package com.jokes.vicevi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	throws Exception {
		
	auth
	.inMemoryAuthentication()
	.withUser("pperic").password("{noop}pero").roles("JOCKER").and()
	.withUser("iivic").password("{noop}ivan").roles("JOCKER");
	};

@Override
protected void configure(HttpSecurity http) throws Exception{

	
	http.formLogin().and().logout().logoutSuccessUrl("/").and()
	.authorizeRequests()
	 .antMatchers("/new").hasRole("JOCKER")
	 .anyRequest().permitAll();
	 
	
}

	
	
	
	
	
}

