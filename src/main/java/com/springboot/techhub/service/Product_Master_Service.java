package com.springboot.techhub.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springboot.techhub.model.Product_Master;

public interface Product_Master_Service {

	// Product_Master product_save(Product_Master_Dto product_Master_Dto);
	List<Product_Master> getAllProduct_Masters();

	public List<Product_Master> getRecentProducts();

	public List<Product_Master> getFeaturedProducts();

	public List<Product_Master> getAllProducts();

	Page<Product_Master> pageProducts(int pageNo);

	Page<Product_Master> getAllProduct(Integer pageNo, Integer pageSize);

	
}
