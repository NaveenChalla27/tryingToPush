package com.mindtree.charlieonline.food.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mindtree.charlieonline.food.model.Customer;
import com.mindtree.charlieonline.food.repository.CustomerRepository;




@Service
public class MyCustomerDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Customer customer=customerRepository.findByEmailId(username);
	if(customer==null) {
		throw new UsernameNotFoundException("not found");
	}
		return new CustomerPrincpal(customer);
	}

}