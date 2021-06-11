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

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.services.OrderlinesService;

@RestController
@RequestMapping("/orderlines")
public class OrderlinesController<orderlinesService> {

	@Autowired
	private OrderlinesService orderlinesService;

	@GetMapping("/{id}")
	public ResponseEntity<Orderlines> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(orderlinesService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Orderlines>> findAll() throws Exception { //se tirar o Service ok ?
		//HttpHeaders headers = new HttpHeaders();
		List<Orderlines> listaTeste = orderlinesService.findAll(); //solução Day
		return ResponseEntity.ok().body(listaTeste);
	}

	@GetMapping("/orderlines")
	public Long count() {
		return orderlinesService.count();
	}

	@PostMapping
	public ResponseEntity<Orderlines> save(@RequestBody Orderlines orderlines) {

		HttpHeaders headers = new HttpHeaders();
		Orderlines newOrderlines = orderlinesService.save(orderlines);

		if (null != newOrderlines)
			return new ResponseEntity<>(newOrderlines, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(newOrderlines, headers, HttpStatus.BAD_REQUEST);
	}

//	@PutMapping
//	public Orderlines update(Orderlines orderlines, Integer id) {
//		return orderlinesService.update(orderlines, id);
//	}

	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable Integer id) {
		orderlinesService.delete(id);
	}
}
