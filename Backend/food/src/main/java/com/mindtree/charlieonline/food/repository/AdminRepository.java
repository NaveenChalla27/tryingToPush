package com.mindtree.charlieonline.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.charlieonline.food.model.Admin;
public interface AdminRepository extends JpaRepository<Admin,Long> {

	Admin findByEmailId(String emailId);

}
