package com.springboot.techhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment_Method {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long payment_method_id;
	private String payment_method_name;
    private String payment_method_Decscription;
    
    public long getPayment_method_id() {
        return payment_method_id;
    }
    public void setPayment_method_id(long payment_method_id) {
        this.payment_method_id = payment_method_id;
    }
    public String getPayment_method_name() {
        return payment_method_name;
    }
    public void setPayment_method_name(String payment_method_name) {
        this.payment_method_name = payment_method_name;
    }
    public String getPayment_method_Decscription() {
        return payment_method_Decscription;
    }
    public void setPayment_method_Decscription(String payment_method_Decscription) {
        this.payment_method_Decscription = payment_method_Decscription;
    }

    public Payment_Method() {
        super();
    }

    public Payment_Method(String payment_method_name, String payment_method_Decscription) {
        super();
        this.payment_method_name = payment_method_name;
        this.payment_method_Decscription = payment_method_Decscription;
    }
    
}
