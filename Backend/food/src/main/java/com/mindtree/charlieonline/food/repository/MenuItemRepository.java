package com.mindtree.charlieonline.food.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.charlieonline.food.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long> 
{

	void deleteAllById(long itemid);

}