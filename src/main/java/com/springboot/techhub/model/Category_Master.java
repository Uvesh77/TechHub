package com.springboot.techhub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category_Master {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private long category_id;
	
	@Column(nullable = false)
	private String categoryname;

	// @OneToMany(mappedBy = "category_Master")
	// private List<Product_Master> product_Masters;
	
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategory_name(String categoryname) {
		this.categoryname = categoryname;
	}
	public Category_Master() {
		super();
	}
	public Category_Master(String categoryname) {
		
		this.categoryname = categoryname;
	}
	// public List<Product_Master> getProduct_Masters() {
	// 	return product_Masters;
	// }
	// public void setProduct_Masters(List<Product_Master> product_Masters) {
	// 	this.product_Masters = product_Masters;
	// }
	
}
