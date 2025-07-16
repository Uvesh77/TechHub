package com.springboot.techhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Order_Master {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderid;
    private String razorOrderid;
    private int amount;
    private String currency;
    private String receipt;
    private String status;
    private String razorPyamentid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid", referencedColumnName = "user_id")
    private Users_Master users_Master;

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getRazorOrderid() {
        return razorOrderid;
    }

    public void setRazorOrderid(String razorOrderid) {
        this.razorOrderid = razorOrderid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRazorPyamentid() {
        return razorPyamentid;
    }

    public void setRazorPyamentid(String razorPyamentid) {
        this.razorPyamentid = razorPyamentid;
    }

    public Users_Master getUsers_Master() {
        return users_Master;
    }

    public void setUsers_Master(Users_Master users_Master) {
        this.users_Master = users_Master;
    }

    
}
