package com.springboot.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.techhub.model.Order_Master;

@Repository
public interface Order_Master_Repository extends JpaRepository<Order_Master,Long>{

    public Order_Master findByRazorOrderid(String razor_Order_id);
    
    // List<Order_Master> findByRazor_Order_id(String razor_Order_id);
}
