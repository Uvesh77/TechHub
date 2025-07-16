package com.springboot.techhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.techhub.model.Order_Master;
import com.springboot.techhub.repository.Order_Master_Repository;

@Service
public class Order_Master_ServiceImpl implements Order_Master_Service{

    @Autowired
    private Order_Master_Repository order_Master_Repository;

    @Override
    public List<Order_Master> GetAllOrderDetails() {
        return order_Master_Repository.findAll();
    }
    
}
