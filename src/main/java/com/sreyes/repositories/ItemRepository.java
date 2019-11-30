package com.sreyes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sreyes.entities.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

	
}
