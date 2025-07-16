package com.springboot.techhub.service;

import com.springboot.techhub.model.Cart_Master;
import com.springboot.techhub.model.Product_Master;
import com.springboot.techhub.model.Users_Master;

public interface Cart_Master_Service {
    Cart_Master addItemToCart(Product_Master product_master, int quantity,Users_Master users_master);

    Cart_Master updateItemInCart(Product_Master product_Master, int quantity, Users_Master users_Master);

    Cart_Master deleteItemFromCart(Product_Master product_Master, Users_Master users_Master);
}
