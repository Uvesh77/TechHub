package com.springboot.techhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.techhub.dto.Payment_Method_Dto;
import com.springboot.techhub.model.Payment_Method;
import com.springboot.techhub.repository.Payment_Method_Repository;

@Service
public class Payment_Method_ServiceImpl implements Payment_Method_Service{

    @Autowired
    private Payment_Method_Repository payment_Method_Repository;

    @Override
    public Payment_Method savePayment_Method(Payment_Method_Dto payment_Method_Dto) {
        Payment_Method payment_Method= new Payment_Method(payment_Method_Dto.getPayment_method_name(), 
                payment_Method_Dto.getPayment_method_Decscription());
        return payment_Method_Repository.save(payment_Method);
    }

    @Override
    public List<Payment_Method> getAllPayment_Method() {
        
        return payment_Method_Repository.findAll();
    }
    
}
