package com.sreyes.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sreyes.model.Item;
import com.sreyes.model.State;
import com.sreyes.repositories.IItemRepo;

@RestController
public class GoodsController {
	
	@Autowired
	private IItemRepo itemRepo;

	
	@GetMapping("/items")
	public List<Item> retrieveAllItems() {
		return itemRepo.findAll();
	}
	
	@GetMapping("/items/{id}")
	public Item retrieveStudent(@PathVariable int id) {
		Optional<Item> item = itemRepo.findById(id);

//		if (!item.isPresent())			
//			throw new ItemNotFoundException("id-" + id);

		return item.get();
	}
	
	
	@DeleteMapping("/items/{id}")
	public void deleteItem(@PathVariable int id) {
		itemRepo.deleteById(id);
	}
	
	@PostMapping("/items")	
	public ResponseEntity<Object> createItem(@RequestBody Item item) {
		Item savedItem  = itemRepo.save(item);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedItem.getId()).toUri();
		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/items/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Item item, 
									@PathVariable int id, 
									@PathVariable String description, 
									@PathVariable double price,
									@PathVariable State state) {

		Optional<Item> studentOptional = itemRepo.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		item.setDescription(description);
		item.setPrice(price);
		item.setState(state);
		
		itemRepo.save(item);

		return ResponseEntity.noContent().build();
	}

}
