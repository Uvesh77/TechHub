package com.springboot.techhub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Brand_Master {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="brand_id")
	private long brandid;
	
	@Column(name="brand_name",nullable = false)
	private String brand_name;
	
	private String Country_of_Origin;

	public long getBrand_id() {
		return brandid;
	}

	public void setBrand_id(long brand_id) {
		this.brandid = brand_id;
	}
	
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

	public Brand_Master() {
		super();
	}

	public Brand_Master(String brand_name, String country_of_Origin) {
		super();
		this.brand_name = brand_name;
		Country_of_Origin = country_of_Origin;
	}

	
	
}
