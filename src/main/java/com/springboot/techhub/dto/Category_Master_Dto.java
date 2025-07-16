package com.springboot.techhub.dto;

public class Category_Master_Dto {
	private String category_name;

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Category_Master_Dto() {
		super();
	}

	public Category_Master_Dto(String category_name) {
		super();
		this.category_name = category_name;
	}
	
}
