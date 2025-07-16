package com.springboot.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.techhub.model.Cart_Item;

@Repository
public interface Cart_Item_Repository extends JpaRepository<Cart_Item, Long>{
    
}
