package com.springboot.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.techhub.model.Brand_Master;

@Repository
public interface Brand_Master_Repository extends JpaRepository<Brand_Master, Long>{

}
