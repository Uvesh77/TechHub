package com.springboot.techhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.techhub.dto.Users_Master_Dto;
import com.springboot.techhub.model.Users_Master;
import com.springboot.techhub.repository.Users_Master_Repository;

@Service
public class Users_Master_ServiceImpl implements Users_Master_Service {

	@Autowired
	private Users_Master_Repository users_Master_Repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Users_Master save(Users_Master_Dto users_Master_Dto) {
		Users_Master users_Master = new Users_Master(users_Master_Dto.getF_Name(), users_Master_Dto.getL_Name(),
				users_Master_Dto.getUsername(),encoder.encode(users_Master_Dto.getPassword()), users_Master_Dto.getUser_email(),
				users_Master_Dto.getPhone_number(), users_Master_Dto.getUser_DOB(), users_Master_Dto.getUser_Role(),users_Master_Dto.getAddress(),users_Master_Dto.getCity());
		
		return users_Master_Repository.save(users_Master);
	}

	@Override
	public Users_Master findByUsername(String username) {
		return users_Master_Repository.findByUsername(username);
	}

	@Override
	public Users_Master saveProfile(Users_Master users_Master) {
		Users_Master users_Master2=users_Master_Repository.findByUsername(users_Master.getUsername());
		
		users_Master2.setF_Name(users_Master.getF_Name());
		users_Master2.setL_Name(users_Master.getL_Name());
		users_Master2.setUser_email(users_Master.getUser_email());
		users_Master2.setPhone_number(users_Master.getPhone_number());
		users_Master2.setUser_DOB(users_Master.getUser_DOB());
		users_Master2.setAddress(users_Master.getAddress());
		users_Master2.setCity(users_Master.getCity());
		users_Master2.setState(users_Master.getState());
		users_Master2.setCountry(users_Master.getCountry());
		users_Master2.setZipCode(users_Master.getZipCode());

		return users_Master_Repository.save(users_Master2);
	}

}
