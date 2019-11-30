package com.sreyes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sreyes.entities.ItemEntity;
import com.sreyes.exceptions.RecordNotFoundException;
import com.sreyes.services.ItemService;

	
@RestController
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	ItemService service;
	
	@GetMapping
	public ResponseEntity<List<ItemEntity>> getAllItems() {
		List<ItemEntity> list = service.getAllItems();
		
		return new ResponseEntity<List<ItemEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemEntity> getItemById(@PathVariable("id") int id) throws RecordNotFoundException {
		
		ItemEntity entity = service.getItemById(id);
		
		return new ResponseEntity<ItemEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@PostMapping("/{id}")
	public ResponseEntity<ItemEntity> createOrUpdateItem(@RequestBody String description, 
														 @RequestBody double price) 
																throws RecordNotFoundException {
		
		ItemEntity item = new ItemEntity();
		item.setDescription(description);
		item.setPrice(price);
		
		ItemEntity updated = service.createOrUpdateItem(item);
		
		return new ResponseEntity<ItemEntity>(updated, new HttpHeaders(), HttpStatus.CREATED);
	}

	
	@DeleteMapping("/{id}")
	public HttpStatus deleteItemById(@PathVariable("id") int id) throws RecordNotFoundException {
		service.deleteItemById(id);
		return HttpStatus.FORBIDDEN;
	}
}
