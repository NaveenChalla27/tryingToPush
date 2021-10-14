package com.mindtree.charlieonline.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.charlieonline.food.model.ItemsList;
import com.mindtree.charlieonline.food.service.ItemsListService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemsListController {
	@Autowired
	private ItemsListService itemsListService;

	@GetMapping("/menuList")
	public List<ItemsList> getAllItems() {
		return itemsListService.getItemsList();
	}
}
