package com.springboot.techhub.dto;

public class Brand_Master_Dto {
	private String brand_name;
	private String Country_of_Origin;
	public String getBrandname() {
		return brand_name;
	}
	public void setBrandname(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getCountry_of_Origin() {
		return Country_of_Origin;
	}
	public void setCountry_of_Origin(String country_of_Origin) {
		Country_of_Origin = country_of_Origin;
	}
	public Brand_Master_Dto() {
		super();
	}
	public Brand_Master_Dto(String brand_name, String country_of_Origin) {
		
		this.brand_name = brand_name;
		Country_of_Origin = country_of_Origin;
	}
	
}
