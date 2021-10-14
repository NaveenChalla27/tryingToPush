package com.mindtree.charlieonline.food.security;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mindtree.charlieonline.food.model.Customer;

public class CustomerPrincpal implements UserDetails {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private  Customer customer;
   CustomerPrincpal(Customer customer){
	   super();
	   this.customer=customer;
   }
 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		return customer.getEmailId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
