package com.springboot.techhub.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.springboot.techhub.service.Custom_Success_Handler;
import com.springboot.techhub.service.Custom_UserDetails_Service;

@Configuration
@EnableWebSecurity
public class Security_Config {

	@Autowired
	public Custom_Success_Handler success_Handler;
	@Autowired
	public Custom_UserDetails_Service custom_UserDetails_Service;
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.csrf(c ->c.disable())
		.authorizeHttpRequests(request-> request.requestMatchers("/admin")
				.hasAuthority("Admin").requestMatchers("/customer").hasAuthority("Customer")
				.requestMatchers("/register","/css/**").permitAll()
				.anyRequest().authenticated())
		.formLogin(form-> form.loginPage("/loginf").loginProcessingUrl("/loginf")
				.successHandler(success_Handler).permitAll())
		.logout(form-> form.invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/loginf?logout").permitAll());
			
		return httpSecurity.build();
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(custom_UserDetails_Service).passwordEncoder(passwordEncoder());
	}
}
