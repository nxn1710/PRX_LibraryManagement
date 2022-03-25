package com.prx.project.library.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prx.project.library.service.UserDetailsServiceImpl;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		http.authorizeHttpRequests()
				.antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**", "/media/**", "/vendor/**", "/resource/**",
						"/login")
				.permitAll().anyRequest().authenticated().and().formLogin()
				.loginProcessingUrl("/j_spring_security_check") 
				.loginPage("/login")
				.usernameParameter("username")//
				.passwordParameter("password").defaultSuccessUrl("/home").permitAll().and().logout()
				.logoutUrl("/logout").logoutSuccessUrl("/login");
	}

}
