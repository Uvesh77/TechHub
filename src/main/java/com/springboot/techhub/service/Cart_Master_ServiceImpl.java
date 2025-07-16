package com.springboot.techhub.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.techhub.model.Cart_Item;
import com.springboot.techhub.model.Cart_Master;
import com.springboot.techhub.model.Product_Master;
import com.springboot.techhub.model.Users_Master;
import com.springboot.techhub.repository.Cart_Item_Repository;
import com.springboot.techhub.repository.Cart_Master_Repository;

@Service
public class Cart_Master_ServiceImpl implements Cart_Master_Service{

    @Autowired
    private Cart_Item_Repository cart_Item_Repository;

    @Autowired
    private Cart_Master_Repository cart_Master_Repository;

    @Override
    public Cart_Master addItemToCart(Product_Master product_master, int quantity, Users_Master users_master) {
        Cart_Master cart_master=users_master.getCart_master();
        if (cart_master == null) {
            cart_master = new Cart_Master();
        }

        Set<Cart_Item> cart_items=cart_master.getCart_item();
        Cart_Item cart_item = findCart_Item(cart_items, product_master.getProduct_id());
        if (cart_items == null) {
            cart_items = new HashSet<>();
            if (cart_item == null) {
                cart_item =new Cart_Item();
                cart_item.setProduct_master(product_master);
                cart_item.setTotal_price(quantity * product_master.getProduct_Price());
                cart_item.setQunatity(quantity);
                cart_item.setCart_Master(cart_master);
                cart_items.add(cart_item);
                cart_Item_Repository.save(cart_item);

            }
        }
        else{
            if (cart_item == null) {
                cart_item =new Cart_Item();
                cart_item.setProduct_master(product_master);
                cart_item.setTotal_price(quantity * product_master.getProduct_Price());
                cart_item.setQunatity(quantity);
                cart_item.setCart_Master(cart_master);
                cart_items.add(cart_item);
                cart_Item_Repository.save(cart_item);
            }
            else{
                cart_item.setQunatity(cart_item.getQunatity() + quantity);
                cart_item.setTotal_price(cart_item.getTotal_price() + (quantity * product_master.getProduct_Price()));
                cart_Item_Repository.save(cart_item);
            }
            
        }
            cart_master.setCart_item(cart_items);
            
            int totalItems = totalItems(cart_master.getCart_item());
            double totalPrice = totalPrice(cart_master.getCart_item());

            cart_master.setTotal_price(totalPrice);
            cart_master.setTotal_items(totalItems);
            cart_master.setUser_Master(users_master);

        return cart_Master_Repository.save(cart_master);
    }

    @Override
    public Cart_Master updateItemInCart(Product_Master product_Master, int quantity, Users_Master users_Master) {
        Cart_Master cart_Master= users_Master.getCart_master();
        Set<Cart_Item> cart_Items=cart_Master.getCart_item();

        Cart_Item item=findCart_Item(cart_Items, product_Master.getProduct_id());
        item.setQunatity(quantity);
        item.setTotal_price(quantity * product_Master.getProduct_Price());
        cart_Item_Repository.save(item);

        int totalItems= totalItems(cart_Items);
        double totalPrice=totalPrice(cart_Items);

        cart_Master.setTotal_items(totalItems);
        cart_Master.setTotal_price(totalPrice);

        return cart_Master_Repository.save(cart_Master);
    }

    // @SuppressWarnings("null")
    @Override
    public Cart_Master deleteItemFromCart(Product_Master product_Master, Users_Master users_Master) {
        Cart_Master cart_Master= users_Master.getCart_master();
        Set<Cart_Item> cart_Items=cart_Master.getCart_item();
        
        Cart_Item item=findCart_Item(cart_Items, product_Master.getProduct_id());
        cart_Items.remove(item);
        cart_Item_Repository.delete(item);

        double totalPrice = totalPrice(cart_Items);
        int totalItems = totalItems(cart_Items);

        cart_Master.setCart_item(cart_Items);
        cart_Master.setTotal_items(totalItems);
        cart_Master.setTotal_price(totalPrice);

        return cart_Master_Repository.save(cart_Master);
    }

    private Cart_Item findCart_Item(Set<Cart_Item> cart_Items, Long product_id){
        if (cart_Items == null) {
            return null;
        }
        Cart_Item cart_Item=null;

        for(Cart_Item item : cart_Items){
            if (item.getProduct_master().getProduct_id() == product_id) {
                cart_Item = item;
            }
        }
        return cart_Item;
    }

    private int totalItems(Set<Cart_Item> cart_Items){
        int totalItems=0;
        for(Cart_Item item : cart_Items){
            totalItems += item.getQunatity();
        }
        return totalItems;
    }

    private double totalPrice(Set<Cart_Item> cart_Items){
        double totalPrice =0.0;
        for(Cart_Item item : cart_Items){
            totalPrice += item.getTotal_price();
        }
        return totalPrice;
    }
    
}
