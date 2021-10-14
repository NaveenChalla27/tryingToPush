package com.mindtree.charlieonline.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.charlieonline.food.model.Cart;
import com.mindtree.charlieonline.food.model.MenuItem;
import com.mindtree.charlieonline.food.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/v1")
public class CustomerController {
	@Autowired
	private CustomerService customerservice;

	@GetMapping("/getAllCartsbyId/{id}")
	public List<Cart> getAllCart(@PathVariable long id) {
		return customerservice.getAllCarts(id);
	}

	@GetMapping("/getAllCartItems/{emailId}")
	public List<MenuItem> getAllCart(@PathVariable String emailId) {
		return customerservice.getCartItems(emailId);
	}

}
