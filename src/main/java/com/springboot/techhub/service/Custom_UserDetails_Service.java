package com.springboot.techhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.techhub.model.Users_Master;
import com.springboot.techhub.repository.Users_Master_Repository;

@Service
public class Custom_UserDetails_Service implements UserDetailsService{

	@Autowired
	private Users_Master_Repository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users_Master users_Master=repository.findByUsername(username);
		if(users_Master==null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new CustomUserDetails(users_Master);
	}

}
