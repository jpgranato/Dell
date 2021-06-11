package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Products;
import com.residencia.dell.repositories.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	public ProductsRepository productsRepository;// cria instancia no Repository

	public Products findById(Integer id) {
		return productsRepository.findById(id).get();
	}

	public List<Products> findAll() {
		return productsRepository.findAll();
	}

	public Long count() {
		return productsRepository.count();
	}

	public Products save(Products products) {
		Products newProducts = productsRepository.save(products);
		return newProducts;
	}

	public Products update(Products product, Integer id) {
		product.setProd_id(id);
		return productsRepository.save(product); // faltando set aqui
	}

	public void delete(Integer id) {
		productsRepository.deleteById(id);
	}
}
