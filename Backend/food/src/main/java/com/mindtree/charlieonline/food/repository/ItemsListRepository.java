package com.mindtree.charlieonline.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.charlieonline.food.model.ItemsList;

public interface ItemsListRepository extends JpaRepository<ItemsList,Long> 
{

}