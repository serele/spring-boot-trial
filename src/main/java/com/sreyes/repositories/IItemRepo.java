package com.sreyes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sreyes.model.Item;

public interface IItemRepo extends JpaRepository<Item, Integer> {

	
}
