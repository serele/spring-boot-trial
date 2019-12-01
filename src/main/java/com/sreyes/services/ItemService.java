package com.sreyes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sreyes.entities.ItemEntity;
import com.sreyes.exceptions.RecordNotFoundException;
import com.sreyes.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository repository;
	
	
	public List<ItemEntity> getAllItems() {
		List<ItemEntity> itemList = repository.findAll();
		
		if(itemList.size() > 0)
			return itemList;
		else
			return new ArrayList<ItemEntity>();
	}
	
	
	public ItemEntity getItemById(int id) throws RecordNotFoundException {
		
		Optional<ItemEntity> item = repository.findById(id);
		
		if(item.isPresent())
				return item.get();
		else
			throw new RecordNotFoundException("No item record exists for given id");
	}
	
	
	public ItemEntity createItem(ItemEntity entity) throws RecordNotFoundException {
	
		entity = repository.save(entity);
		
		return entity;
	}
	
	public ItemEntity updateItem(ItemEntity entity) throws RecordNotFoundException {
		
		Optional<ItemEntity> item = repository.findById(entity.getId());
		
		if(item.isPresent()) {
			ItemEntity newEntity = item.get();
			newEntity.setDescription(entity.getDescription());
			newEntity.setPrice(entity.getPrice());
			newEntity.setState(entity.getState());
			newEntity.setCreation_date(entity.getCreation_date());
			newEntity.setCreator(entity.getCreator());
			
			newEntity = repository.save(entity);
			
			return newEntity;			
		}
		else
			throw new RecordNotFoundException("No item record exists for given id");
	}
		
	public void deleteItemById(int id) throws RecordNotFoundException {
		
		Optional<ItemEntity> item = repository.findById(id);
		
		if(item.isPresent())
			repository.deleteById(id);
		else
			throw new RecordNotFoundException("No item record exists for given id");
	}
}
