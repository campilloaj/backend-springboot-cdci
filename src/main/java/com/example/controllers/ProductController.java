package com.example.controllers;

import com.example.services.IProduct;
import com.example.models.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private IProduct repository;
	 
	@GetMapping
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	@PostMapping("/save")
	public Object addProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		repository.deleteById(id);
	}

	@GetMapping(value = "/get/{id}")
	public Optional<Product> getProduct(@PathVariable int id){
		return repository.findById(id);
	}
	  
	@PutMapping("/update")
	public void UpdatePruduct(@RequestBody Product product){
		  repository.saveAndFlush(product);
	} 
	
}
