package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Service;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().maximumSessions(5);
		http.authorizeRequests().antMatchers("/registered/**").permitAll()/*.and().authorizeRequests().antMatchers("/admin").permitAll();*/
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().permitAll();
		http.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
	  throws Exception {
	    auth.userDetailsService(userDetailsService);
	    auth.inMemoryAuthentication().withUser("user1").password("password1").roles("USER");
	    auth.inMemoryAuthentication().withUser("usera").password("passadmin1").roles("ADMIN");    
	}
	
}
