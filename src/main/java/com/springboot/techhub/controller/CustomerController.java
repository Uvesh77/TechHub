package com.springboot.techhub.controller;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.techhub.model.Cart_Master;
import com.springboot.techhub.model.Product_Master;
import com.springboot.techhub.model.Users_Master;
import com.springboot.techhub.repository.Product_Master_Repository;
import com.springboot.techhub.service.Cart_Master_Service;
import com.springboot.techhub.service.Product_Master_Service;
import com.springboot.techhub.service.Users_Master_Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {

	@Autowired
	private Product_Master_Repository product_Master_Repository;

	@Autowired
	private Users_Master_Service users_Master_Service;

	@Autowired
	private Cart_Master_Service cart_Master_Service;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private Product_Master_Service product_Master_Service;

	// @Autowired
	// private Users_Master_Repository users_Master_Repository;

	@GetMapping("/customer")
	public String getCustomerPage(Model model,Principal principal, HttpSession session) {
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		// session.setAttribute("user_name", userDetails);
		model.addAttribute("user_Master", userDetails);
		List<Product_Master> recentProducts=product_Master_Service.getRecentProducts();
		model.addAttribute("recent_products", recentProducts);
		List<Product_Master> featuredProducts = product_Master_Service.getFeaturedProducts();
        model.addAttribute("featured_products", featuredProducts);

		// List<Product_Master> getCategory=product_Master_Repository.findByCategory();
		// model.addAttribute("pcategory", getCategory);

		if (principal != null) {
			String user=principal.getName();
			Users_Master users_Master=users_Master_Service.findByUsername(user);
			Cart_Master cart=users_Master.getCart_master();
			if (cart != null) {
				session.setAttribute("totalItems",cart.getTotal_items());
			}
			
		}
		
		
		return "customer";
	}
    
    @GetMapping("/contact")
	public String getContactPage(){
		return "contact";
	}

    @SuppressWarnings("null")
	@GetMapping("/cart")
	public String getCartPage(Model model,Principal principal, HttpSession session){

		String username=principal.getName();
		Users_Master users_Master=users_Master_Service.findByUsername(username);
		Cart_Master cart_Master=users_Master.getCart_master();
		if (cart_Master == null) {
			model.addAttribute("check", "No Item Found In Cart");
			model.addAttribute("emptycart", cart_Master.getTotal_prices());
		}
		session.setAttribute("totalItems", cart_Master.getTotal_items());
		model.addAttribute("subTotal", cart_Master.getTotal_prices());
		model.addAttribute("Cart_Master", cart_Master);

		return "cart";
	}

	@SuppressWarnings("unused")
	@PostMapping("/add-to-cart")
	public String getAddItemCart(
		@RequestParam("id") long product_id,
		@RequestParam(value = "quantity", required = false, defaultValue = "1") int quantity,
		Model model,
		Principal principal,
		HttpServletRequest request){

		Product_Master product_Master= product_Master_Repository.findById(product_id).get();
		String username=principal.getName();
		Users_Master users_Master=users_Master_Service.findByUsername(username);

		Cart_Master cart=cart_Master_Service.addItemToCart(product_Master, quantity, users_Master);
		
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "/update-cart", method = RequestMethod.POST, params = "action=Update")
	public String updaetCart(@RequestParam("quantity") int quantity, @RequestParam("id") long product_id, Model model, Principal principal){

		String username= principal.getName();
		Users_Master users_Master=users_Master_Service.findByUsername(username);
		Product_Master product_Master=product_Master_Repository.findById(product_id).get();
		Cart_Master cart=cart_Master_Service.updateItemInCart(product_Master, quantity, users_Master);
		model.addAttribute("Cart_Master", cart);

		return "redirect:/cart";
	}

	@RequestMapping(value = "/update-cart", method = RequestMethod.POST, params = "action=Delete")
	public String deleteItemFromCart(@RequestParam("id") long product_id, Model model, Principal principal){
		String username= principal.getName();
		Users_Master users_Master=users_Master_Service.findByUsername(username);
		Product_Master product_Master=product_Master_Repository.findById(product_id).get();
		Cart_Master cart=cart_Master_Service.deleteItemFromCart(product_Master, users_Master);
		model.addAttribute("Cart_Master", cart);

		return "redirect:/cart";
	}


	@GetMapping("/shop")
	public String getShopPage(Model model,@RequestParam(value = "pageNo", defaultValue = "0", required=false) Integer pageNo,
		@RequestParam(value = "pageSize", defaultValue = "6", required = false) Integer pageSize){

		Page<Product_Master> page= product_Master_Service.getAllProduct(pageNo, pageSize);
		model.addAttribute("page", page);
		return "shop";
	}

	@GetMapping("/detail")
	public String getShopDetailPage(Model model,@RequestParam long id){

		List<Product_Master> allProducts = product_Master_Service.getAllProducts();
        model.addAttribute("allProducts", allProducts);
		Product_Master product_Master=product_Master_Repository.findById(id).get();
		model.addAttribute("products", product_Master);
		return "detail";
	}

	@GetMapping("/profile")
	public String getProfile(Model model, Principal principal){
		String username=principal.getName();
		Users_Master users_Master=users_Master_Service.findByUsername(username);
		model.addAttribute("profile", users_Master);
		return "profile";
	}

	@PostMapping("/update-profile")
	public String updateProfile(Model model, Principal principal,@ModelAttribute("users_Master") Users_Master users_Master,RedirectAttributes redirectAttributes){
		// String username=principal.getName();
		Users_Master users_MasterSaved=users_Master_Service.saveProfile(users_Master);
		redirectAttributes.addFlashAttribute("profile",users_MasterSaved);
		// model.addAttribute("profile", users_MasterSaved);
		return "redirect:/profile";
	}
    
	
}
