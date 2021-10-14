package com.mindtree.charlieonline.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mindtree.charlieonline.food.model.Cart;
import com.mindtree.charlieonline.food.model.MenuItem;



public interface CartRepository extends JpaRepository<Cart,Long>{
    
	//@Query("Select c from Cart c where c.customerId=?1")
	List<MenuItem> findMenuItemsByCustomerId(long id);

}