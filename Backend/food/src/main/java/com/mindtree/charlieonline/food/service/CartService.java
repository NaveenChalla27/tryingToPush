package com.mindtree.charlieonline.food.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.charlieonline.food.expection.ResourceNotFoundException;
import com.mindtree.charlieonline.food.model.Cart;
import com.mindtree.charlieonline.food.model.Customer;
import com.mindtree.charlieonline.food.model.MenuItem;
import com.mindtree.charlieonline.food.repository.CartRepository;
import com.mindtree.charlieonline.food.repository.CustomerRepository;
import com.mindtree.charlieonline.food.repository.MenuItemRepository;


@Service
public class CartService 
{
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	public List<Cart> getCarts()
	{
		return cartRepository.findAll();
	}

	public Cart customerCart(Cart cart,long id) 
	{
		 Customer customer=customerRepository.getById(id);
		 customer.setCart(customer.getCart());
		 cart.setCustomer(customer);
		return cartRepository.save(cart);
	}
	
	public String deleteItemInCartById(Long id,String item1) 
	{
		Cart cart=cartRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Course with id"+ id+ " is not found"));
		List<MenuItem> items=cart.getMenu();
		for(MenuItem item2:items)
		{
			String itemname=item2.getItemname();
			if(itemname.equals(item1)) 
			{
				items.remove(item2);
				menuItemRepository.saveAll(items);
				return "Item  got Deleted";
			}
		}
		return "Item not got Deleted";

	}

	public List<MenuItem> getCarItems(long id) {
		Cart cart= cartRepository.getById(id);
		return cart.getMenu();
	}

	public Cart cartOfCustomer(Cart cart, String customerEmailId) {
		Customer customer=customerRepository.findByEmailId(customerEmailId);
		 customer.setCart(customer.getCart());
		 cart.setCustomer(customer);
		return cartRepository.save(cart);
	}


}
