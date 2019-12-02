package com.sreyes.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sreyes.exceptions.RecordNotFoundException;
import com.sreyes.model.ItemEntity;
import com.sreyes.model.State;
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
	
	
	@PostMapping("/add")
	public ResponseEntity<ItemEntity> createItem(@Valid @RequestBody ItemEntity item) 
																throws RecordNotFoundException {

		ItemEntity created = service.createItem(item);
		
		return new ResponseEntity<ItemEntity>(created, new HttpHeaders(), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemEntity> updateItem(@PathVariable("id") int id, 
												 @Valid @RequestBody ItemEntity item) 
																throws RecordNotFoundException {		
		
		ItemEntity updated = service.updateItem(item);
		
		return new ResponseEntity<ItemEntity>(updated, new HttpHeaders(), HttpStatus.ACCEPTED);
	}

	
	@DeleteMapping("/del/{id}")
	public HttpStatus deleteItemById(@PathVariable("id") int id) throws RecordNotFoundException {
		service.deleteItemById(id);
		return HttpStatus.OK;
	}
}
