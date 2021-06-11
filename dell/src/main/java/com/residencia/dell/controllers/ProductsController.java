package com.residencia.dell.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.residencia.dell.entities.Products;
import com.residencia.dell.services.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private ProductsService productsService;

	@GetMapping("/{id}")
	public ResponseEntity<Products> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(productsService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Products>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(productsService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping("/products")
	public Long count() {
		return productsService.count();
	}

	@PostMapping
	public ResponseEntity<Products> save(@RequestBody Products product) {

		HttpHeaders headers = new HttpHeaders();
		Products newProduct = productsService.save(product);

		if (null != newProduct)
			return new ResponseEntity<>(newProduct, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(newProduct, headers, HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	public Products update(Products product, Integer id) {
		return productsService.update(product, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable Integer id) {
		productsService.delete(id);
	}
}
