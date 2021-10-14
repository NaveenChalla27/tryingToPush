package com.mindtree.charlieonline.food.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.charlieonline.food.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

	Customer findByEmailId(String username);

}