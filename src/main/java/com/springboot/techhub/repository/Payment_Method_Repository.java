package com.springboot.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.techhub.model.Payment_Method;

@Repository
public interface Payment_Method_Repository extends JpaRepository<Payment_Method, Long> {
    
}
