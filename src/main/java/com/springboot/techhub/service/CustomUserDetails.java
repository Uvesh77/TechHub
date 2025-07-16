package com.springboot.techhub.service;

import java.util.Collection;
import java.util.Collections;
// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.techhub.model.Users_Master;


public class CustomUserDetails implements UserDetails {

	@Autowired
	private Users_Master users_Master;
	
	public CustomUserDetails(Users_Master users_Master) {
		this.users_Master = users_Master;
	}

	@Override
	public Collection <? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singletonList(()->users_Master.getUser_Role());
	}

	
	@Override
	public String getPassword() {
		
		return users_Master.getPassword();
	}

	@Override
	public String getUsername() {
		
		return users_Master.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
