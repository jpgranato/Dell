package com.residencia.dell.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.dell.entities.Orders;
import com.residencia.dell.services.OrdersService;
import com.residencia.dell.vo.OrdersVO;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;

//	@GetMapping("/{id}")
//	public ResponseEntity<Orders> findById(@PathVariable Integer id) {
//		HttpHeaders headers = new HttpHeaders();
//		return new ResponseEntity<>(ordersService.findById(id), headers, HttpStatus.OK);
//	}
//
//	@GetMapping("/NF/{id}")
//	public ResponseEntity<NotaFiscalVO> emitirNF(@PathVariable Integer id) {
//		HttpHeaders headers = new HttpHeaders();
//		return new ResponseEntity<>(ordersService.emitirNF(id), headers, HttpStatus.OK);
//	}
//	@GetMapping
//	public ResponseEntity<List<Orders>> findAll(@RequestParam(required = false) Integer pagina,
//			@RequestParam(required = false) Integer qtdRegistros) throws Exception {
//
//		HttpHeaders headers = new HttpHeaders();
//		return new ResponseEntity<>(ordersService.findAll(pagina, qtdRegistros), headers, HttpStatus.OK);
//	}
//
//	@GetMapping("/listar-todos")
//	public ResponseEntity<List<OrdersVO>> findAllVO(@RequestParam(required = false) Integer pagina,
//			@RequestParam(required = false) Integer qtdRegistros) throws Exception {
//
//		HttpHeaders headers = new HttpHeaders();
//		return new ResponseEntity<>(ordersService.findAllVO(pagina, qtdRegistros), headers, HttpStatus.OK);
//	}
//
//	@GetMapping("/count")
//	public Long count() {
//		return ordersService.count();
//	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Orders> save(@Valid @RequestBody OrdersVO order) {

		HttpHeaders headers = new HttpHeaders();
		Orders newOrders = ordersService.saveVO(order);

		if (null != newOrders)
			return new ResponseEntity<>(newOrders, headers, HttpStatus.OK);
		else
			return ResponseEntity.unprocessableEntity().build();
	}

	// @PutMapping("/{id}")
	// public ResponseEntity<Orders> update(@PathVariable Integer id, @RequestBody
	// Orders orders) {
	// HttpHeaders headers = new HttpHeaders();
	// return new ResponseEntity<>(ordersService.update(orders, id), headers,
	// HttpStatus.OK);
	// }
	//
	// @DeleteMapping("/{id}")
	// public ResponseEntity<Orders> delete(@PathVariable Integer id) {
	// try {
	// ordersService.delete(id);
	// } catch (Exception e) {
	// return ResponseEntity.notFound().build();
	// }
	// return ResponseEntity.ok().build();
	// }
}
