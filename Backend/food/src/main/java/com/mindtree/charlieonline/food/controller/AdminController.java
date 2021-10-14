package com.mindtree.charlieonline.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mindtree.charlieonline.food.model.Customer;
import com.mindtree.charlieonline.food.model.ItemsList;
import com.mindtree.charlieonline.food.service.AdminService;
import com.mindtree.charlieonline.food.service.CustomerService;
import com.mindtree.charlieonline.food.service.ItemsListService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/v1")
public class AdminController {
	@Autowired
	private AdminService adminservice;
	@Autowired
	private CustomerService customerService;

	@Autowired
	private ItemsListService itemsListService;

	/*
	 * @PostMapping("/admin/logindetails") public boolean loginDetails(@RequestBody
	 * Admin admin) { return adminservice.checkingCredentials(admin); }
	 */

	@GetMapping("admin/getAllMenuItems/")
	public List<ItemsList> getAllItems() {
		return itemsListService.getItemsList();

	}

	@DeleteMapping("/admin/deleteItem/{id}")
	public String deleteItemById(@PathVariable long id) {
		return adminservice.deleteItem(id);
	}

	@PostMapping("/admin/addItem")
	public ItemsList addItem(@PathVariable ItemsList item) {
		return adminservice.addingItem(item);
	}

	@PutMapping("/admin/updateItem/{id}")
	public ItemsList updateItem(@PathVariable ItemsList item, @PathVariable long id) {
		return adminservice.updatingItem(item, id);
	}

	@GetMapping("admin/getAllcustomers/")
	public List<Customer> getAllCustomers() {
		return customerService.getAllcustomers();

	}

}
