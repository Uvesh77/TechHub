package com.springboot.techhub.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Cart_Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_item_id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    private Cart_Master Cart_Master;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product_Master product_master;

    private int qunatity;

    private double unit_price;
    
    public double total_price;
    
    public long getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(long cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public Cart_Master getCart_Master() {
        return Cart_Master;
    }

    public void setCart_Master(Cart_Master Cart_Master) {
        this.Cart_Master = Cart_Master;
    }

    public Product_Master getProduct_master() {
        return product_master;
    }

    public void setProduct_master(Product_Master product_master) {
        this.product_master = product_master;
    }

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    
    public Cart_Item() {
        super();
    }

    public Cart_Item(Cart_Master Cart_Master, Product_Master product_master, int qunatity, double unit_price) {
        this.Cart_Master = Cart_Master;
        this.product_master = product_master;
        this.qunatity = qunatity;
        this.unit_price = unit_price;
    }

    @Override
    public String toString() {
        return "Cart_Item [cart_item_id=" + cart_item_id + ", cart_master=" + Cart_Master + ", product_master="
                + product_master + ", cart_Qunatity=" + qunatity + ", unit_price=" + unit_price + ", total_price="
                + total_price + "]";
    }
}
