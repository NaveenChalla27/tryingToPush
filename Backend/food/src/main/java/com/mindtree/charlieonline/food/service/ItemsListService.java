package com.mindtree.charlieonline.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.charlieonline.food.model.ItemsList;
import com.mindtree.charlieonline.food.repository.ItemsListRepository;

@Service
public class ItemsListService {
	@Autowired
    private ItemsListRepository itemsListRepository;
	public List<ItemsList> getItemsList() {
		return itemsListRepository.findAll();
	}

}
