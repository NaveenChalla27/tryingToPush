package com.mindtree.charlieonline.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mindtree.charlieonline.food.model.Cart;
import com.mindtree.charlieonline.food.model.Customer;
import com.mindtree.charlieonline.food.model.MenuItem;
import com.mindtree.charlieonline.food.repository.CartRepository;
import com.mindtree.charlieonline.food.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CartRepository cartRepository;

	public void addCustomer(Customer customer) {
		String password = passwordEncoder.encode(customer.getPassword());
		customer.setPassword(password);
		customerRepository.save(customer);
	}

	public List<Cart> getAllCarts(long id) {
		Customer customer = customerRepository.findById(id).orElse(null);
		return customer.getCart();
	}

	public List<Customer> getAllcustomers() {
		return customerRepository.findAll();
	}

	public List<MenuItem> getCartItems(String emailId) {
		Customer customer = customerRepository.findByEmailId(emailId);
		long id = customer.getId();
		return cartRepository.findMenuItemsByCustomerId(id);
	}

}
