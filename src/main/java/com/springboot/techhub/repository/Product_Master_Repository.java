package com.springboot.techhub.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.techhub.model.Product_Master;

@Repository
public interface Product_Master_Repository extends JpaRepository<Product_Master, Long>{

    List<Product_Master> findTop8ByOrderByCreatedAtDesc();

    List<Product_Master> findFirst8ByOrderByCreatedAt();

    @Query("Select p from Product_Master p")
    Page<Product_Master> pageProduct_Master(Pageable pageable);

    // List<Product_Master> findByForm_Factor(String Form_Factor);
    
    // @Query("SELECT p.product_name, p.Product_Image, c.categoryname FROM Product_Master p, Category_Master c WHERE p.category_id = c.category_id AND p.form_factor = 'laptop'")
    // List<Product_Master> findByCategory();
}
