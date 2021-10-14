package com.mindtree.charlieonline.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.charlieonline.food.model.Cart;
import com.mindtree.charlieonline.food.model.MenuItem;
import com.mindtree.charlieonline.food.service.CartService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	@Autowired
	CartService cartService;

	@GetMapping("/carts")
	public List<Cart> getAllCart() {
		return cartService.getCarts();
	}

	@PostMapping("/{customerId}/cart")
	public Cart addcartToCustomer(@PathVariable long customerId, @RequestBody Cart cart) {
		return cartService.customerCart(cart, customerId);
	}

	@DeleteMapping("/cart/{cartId}/{itemName}")
	public String deleteItemInCart(@PathVariable long cartId, @PathVariable String itemName) {

		return cartService.deleteItemInCartById(cartId, itemName);

	}

	@GetMapping("/cart/{cartId}/items")
	public List<MenuItem> getAllCartItems(@PathVariable long cartId) {
		return cartService.getCarItems(cartId);
	}

	@PostMapping("/{customerEmailId}/cart")
	public Cart addingcartToCustomer(@PathVariable String customerEmailId, @RequestBody Cart cart) {
		return cartService.cartOfCustomer(cart, customerEmailId);
	}

}
