package com.springboot.techhub.service;

import com.springboot.techhub.dto.Users_Master_Dto;
import com.springboot.techhub.model.Users_Master;

public interface Users_Master_Service {

	Users_Master save(Users_Master_Dto users_Master_Dto);

	Users_Master findByUsername(String username);

	Users_Master saveProfile(Users_Master users_Master);
}
