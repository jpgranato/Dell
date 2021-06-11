package com.residencia.dell.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.dell.entities.Customers;
import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;
import com.residencia.dell.repositories.CustomersRepository;
import com.residencia.dell.repositories.OrderlinesRepository;
import com.residencia.dell.repositories.OrdersRepository;
import com.residencia.dell.repositories.ProductsRepository;
import com.residencia.dell.vo.OrderLinesVO;
import com.residencia.dell.vo.OrdersVO;

@Service
public class OrdersService {

	@Autowired
	public OrdersRepository ordersRepository;

	@Autowired
	public OrderlinesRepository orderLinesRepository;

	@Autowired
	public ProductsRepository productsRepository;

	@Autowired
	public CustomersRepository customersRepository;

//	@Autowired
//	public EmailService emailService;

	public Orders saveVO(OrdersVO ordersVO) {

		Orders orders = new Orders();
		Customers customer = customersRepository.getById(ordersVO.getCustomers());

		orders.setNetAmount(ordersVO.getNetAmount());
		orders.setOrderDate(ordersVO.getOrderDate());
		orders.setOrderId(ordersVO.getOrderId());
		orders.setTax(ordersVO.getTax());
		orders.setTotalAmount(ordersVO.getTotalAmount());
		orders.setCustomer(customer);

		Orders newOrders = ordersRepository.save(orders);

		Integer contadorOrderlinesId = 1;

		for (OrderLinesVO itemOrderLinesVO : ordersVO.getListOrderLinesVO()) {
			Orderlines orderlines = new Orderlines(contadorOrderlinesId, newOrders.getOrderId(),
					itemOrderLinesVO.getProdId(), itemOrderLinesVO.getQuantity(), itemOrderLinesVO.getOrderDate());

			Orderlines newOrderlines = orderLinesRepository.save(orderlines);

			contadorOrderlinesId++;
		}

		return newOrders;

	}

}