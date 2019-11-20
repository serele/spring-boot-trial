package com.sreyes.services;

import java.util.List;

import com.sreyes.model.Item;

public interface IItemService {
	
	List<Item> listAll();
	
	Item getById(int id);
	
	

}
