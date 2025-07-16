package com.springboot.techhub.dto;

public class Payment_Method_Dto {
    
    private String payment_method_name;
    private String payment_method_Decscription;
    
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

    public Payment_Method_Dto() {
        super();
    }
    
    public Payment_Method_Dto(String payment_method_name, String payment_method_Decscription) {
        this.payment_method_name = payment_method_name;
        this.payment_method_Decscription = payment_method_Decscription;
    }
    
}
