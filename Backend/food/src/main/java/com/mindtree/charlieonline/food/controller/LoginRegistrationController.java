package com.mindtree.charlieonline.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.charlieonline.food.model.Admin;
import com.mindtree.charlieonline.food.model.Customer;
import com.mindtree.charlieonline.food.service.AdminService;
import com.mindtree.charlieonline.food.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginRegistrationController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AdminService adminService;

// CUSTOMER
	@GetMapping("/login")
	public void loginpage() {

	}

	@PostMapping(path = "/register")
	public void register(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

// AdMIN
	@PostMapping("/admin/logindetails")
	public boolean loginDetails(@RequestBody Admin admin) {
		return adminService.checkingCredentials(admin);
	}

	@PostMapping(path = "admin/register")
	public void adminRegister(@RequestBody Admin admin) {
		adminService.addAdmin(admin);
	}

}
