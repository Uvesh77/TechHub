package com.springboot.techhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.techhub.dto.Brand_Master_Dto;
import com.springboot.techhub.model.Brand_Master;
import com.springboot.techhub.repository.Brand_Master_Repository;

@Service
public class Brand_Master_ServiceImpl implements Brand_Master_Service {

	@Autowired
	private Brand_Master_Repository brand_Master_Repository;

	@Override
	public Brand_Master brand_save(Brand_Master_Dto brand_Master_Dto) {
		Brand_Master brand_Master = new Brand_Master(brand_Master_Dto.getBrandname(),
				brand_Master_Dto.getCountry_of_Origin());
		return brand_Master_Repository.save(brand_Master);
	}

}
