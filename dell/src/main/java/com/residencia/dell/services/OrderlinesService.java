package com.residencia.dell.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.repositories.OrderlinesRepository;
@Service
public class OrderlinesService {
	@Autowired
	public OrderlinesRepository orderlinesRepository;// cria instancia no Repository

	public Orderlines findById(Integer id) {
		return orderlinesRepository.findById(id).get();
	}

	public List<Orderlines> findAll() {
		return orderlinesRepository.findAll();
	}

	public Long count() {
		return orderlinesRepository.count();
	}

	public Orderlines save(Orderlines orderlines) {
		Orderlines neworderlines = orderlinesRepository.save(orderlines);
		return neworderlines;
	}

//	public Orderlines update(Orderlines orderlines, Integer id) {
//		orderlines.setOrderLinesId(id);
//		return orderlinesRepository.save(orderlines); 
//	}

	public void delete(Integer id) {
		orderlinesRepository.deleteById(id);
	}
}
