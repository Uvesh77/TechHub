package com.springboot.techhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.techhub.model.Category_Master;

@Repository
public interface Category_Master_Repository extends JpaRepository<Category_Master, Long>{

	List<Category_Master> findByCategoryname(String categoryname);

	// @Query("Select c,Count(p) From Category_Master c Left Join c.product_Masters p Group By c")
	// List<Object[]> findCategory_MasterWithProduct_MasterCount();
}
