package com.springboot.techhub.service;

import java.util.List;

import com.springboot.techhub.dto.Category_Master_Dto;
import com.springboot.techhub.model.Category_Master;

public interface Category_Master_Service {

	Category_Master category_save(Category_Master_Dto category_Master_Dto);
	public List<Category_Master> listAllCategory();
}
