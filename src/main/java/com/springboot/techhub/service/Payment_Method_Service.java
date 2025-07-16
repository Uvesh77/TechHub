package com.springboot.techhub.service;

import java.util.List;

import com.springboot.techhub.dto.Payment_Method_Dto;
import com.springboot.techhub.model.Payment_Method;


public interface Payment_Method_Service {
    
    Payment_Method savePayment_Method(Payment_Method_Dto payment_Method_Dto);

    public List<Payment_Method> getAllPayment_Method();
}
