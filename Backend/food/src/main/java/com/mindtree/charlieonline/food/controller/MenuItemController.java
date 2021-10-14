package com.mindtree.charlieonline.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.charlieonline.food.model.MenuItem;
import com.mindtree.charlieonline.food.service.MenuItemService;

@RestController
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;

	@GetMapping("/menu")
	public List<MenuItem> getAllItems() {
		return menuItemService.getMenuItems();
	}

	@PostMapping("/menu")
	public MenuItem addItemstoCart(@RequestBody MenuItem menuitem) {
		return menuItemService.addItemsTocart(menuitem);
	}
}
