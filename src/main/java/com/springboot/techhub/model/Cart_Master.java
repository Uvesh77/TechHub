package com.springboot.techhub.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Cart_Master {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users_Master User_Master;

    private double total_prices;

    private int total_items;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Cart_Master")
    public Set<Cart_Item> cart_item;

    public long getCart_id() {
        return cart_id;
    }

    public void setCart_id(long cart_id) {
        this.cart_id = cart_id;
    }

    public Users_Master getUser_Master() {
        return User_Master;
    }

    public void setUser_Master(Users_Master User_Master) {
        this.User_Master = User_Master;
    }

    public double getTotal_prices() {
        return total_prices;
    }

    public void setTotal_price(double total_prices) {
        this.total_prices = total_prices;
    }

    public int getTotal_items() {
        return total_items;
    }

    public void setTotal_items(int total_items) {
        this.total_items = total_items;
    }

    public Set<Cart_Item> getCart_item() {
        return cart_item;
    }

    public void setCart_item(Set<Cart_Item> cart_item) {
        this.cart_item = cart_item;
    }

    public Cart_Master(){
        this.cart_item=new HashSet<>();
        this.total_items=0;
        this.total_prices=0.0;
    }

    @Override
    public String toString() {
        return "Cart_Master [cart_id=" + cart_id + ", user_master=" + User_Master + ", total_prices=" + total_prices
                + ", total_items=" + total_items + ", cart_item=" + cart_item + "]";
    }

    
}
