package com.springboot.techhub.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.techhub.dto.Category_Master_Dto;
import com.springboot.techhub.model.Category_Master;
import com.springboot.techhub.repository.Category_Master_Repository;

@Service
public class Category_Master_ServiceImpl implements Category_Master_Service{

	@Autowired
	private Category_Master_Repository category_Master_Repository;

	@Override
	public Category_Master category_save(Category_Master_Dto category_Master_Dto) {
		Category_Master category_Master=new Category_Master(category_Master_Dto.getCategory_name());
		return category_Master_Repository.save(category_Master);
	}

	@Override
	public List<Category_Master> listAllCategory() {
		
		return category_Master_Repository.findAll();
	}
	
	
}
