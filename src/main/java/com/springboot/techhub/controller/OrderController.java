package com.springboot.techhub.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.springboot.techhub.model.Cart_Master;
import com.springboot.techhub.model.Order_Master;
import com.springboot.techhub.model.Payment_Method;
import com.springboot.techhub.model.Users_Master;
import com.springboot.techhub.repository.Order_Master_Repository;
import com.springboot.techhub.service.Payment_Method_Service;
import com.springboot.techhub.service.Users_Master_Service;

@Controller
public class OrderController {

    @Autowired
    private Users_Master_Service users_Master_Service;

    // @Autowired
    // private Payment_Method_Repository payment_Method_Repository;

    @Autowired
    private Payment_Method_Service payment_Method_Service;

    @Autowired
    private Order_Master_Repository order_Master_Repository;
    
    @SuppressWarnings("null")
    @GetMapping("/checkout")
    public String checkout(Model model, Principal principal){


        String username=principal.getName();
        Users_Master users_Master= users_Master_Service.findByUsername(username);
        if (users_Master.getPhone_number().isEmpty() || users_Master.getAddress( ).isEmpty() || users_Master.getCity().isEmpty() ||
            users_Master.getState() == null || users_Master.getZipCode() == null || users_Master.getCountry() == null
            ) {
            model.addAttribute("profile", users_Master);
            model.addAttribute("error", "You Must Fill The Information Before Checkout");
            return "/profile";
        }else{
            model.addAttribute("getUserData", users_Master);
            Cart_Master cart_Master=users_Master.getCart_master();
            model.addAttribute("cart", cart_Master);
            if (cart_Master == null) {
                model.addAttribute("check", "No Item Found In Cart");
                model.addAttribute("emptycart", cart_Master.getTotal_prices());
            }
            model.addAttribute("subTotal", cart_Master.getTotal_prices());
		model.addAttribute("Cart_Master", cart_Master);
        }
        // users_Master_Service.saveProfile(users_Master);
        
        List<Payment_Method> payment_Method= payment_Method_Service.getAllPayment_Method();
        model.addAttribute("getPaymentMethod", payment_Method);

        return "checkout";
    }

    @PostMapping("/create_order")
    @ResponseBody
    public String createOrder(@RequestBody Map<String, Object> data, Principal principal) throws Exception{
        System.out.println(data);
        float amt=Float.parseFloat(data.get("amount").toString());

        var client =new RazorpayClient("rzp_test_lgnhBaGi7UvJEA", "kcTbk73cLIZYzgvLMAy9jdYU");
        JSONObject jObject=new JSONObject();
        jObject.put("amount", amt*100);
        jObject.put("currency", "INR");
        jObject.put("receipt", "txn_235425");

        //Creating new order
        Order order =  client.orders.create(jObject);
        System.out.println(order);

        //adding order data to database
        Order_Master order_Master= new Order_Master();
        order_Master.setRazorOrderid(order.get("id"));
        int ramt= order.get("amount");
        ramt=ramt/100;
        order_Master.setAmount(ramt);
        order_Master.setCurrency(order.get("currency"));
        order_Master.setRazorPyamentid(null);
        order_Master.setStatus("created");
        order_Master.setUsers_Master(this.users_Master_Service.findByUsername(principal.getName()));
        order_Master.setReceipt(order.get("receipt"));

        order_Master_Repository.save(order_Master);

        return order.toString();
    }

    @PostMapping("/update_order")
    public ResponseEntity<?> updateOrder(@RequestBody Map<String, Object> data){
        
        Order_Master order_Master =  this.order_Master_Repository.findByRazorOrderid(data.get("order_id").toString());

        order_Master.setRazorPyamentid(data.get("payment_id").toString());
        order_Master.setStatus(data.get("status").toString());

        order_Master_Repository.save(order_Master);
        System.out.println(data);
        return ResponseEntity.ok(Map.of("masg","Updated"));
    }
}
