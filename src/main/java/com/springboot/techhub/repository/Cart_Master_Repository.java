package com.springboot.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.techhub.model.Cart_Master;

@Repository
public interface Cart_Master_Repository extends JpaRepository<Cart_Master,Long>{
    
}
