package com.mindtree.charlieonline.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.charlieonline.food.model.MenuItem;
import com.mindtree.charlieonline.food.repository.MenuItemRepository;

@Service
public class MenuItemService
{
	
	@Autowired
	MenuItemRepository menuRepository;
	
	public List<MenuItem> getMenuItems()
	{
		return menuRepository.findAll();
	}
	
	public MenuItem addItemsTocart(MenuItem menuitem) {
		return menuRepository.save(menuitem);
		
	}
}
