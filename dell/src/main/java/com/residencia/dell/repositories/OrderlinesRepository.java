package com.residencia.dell.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.dell.entities.Orderlines;
import com.residencia.dell.entities.Orders;

public interface OrderlinesRepository extends JpaRepository<Orderlines, Integer>{
	List<Orderlines> findByOrders(Orders orders);
}
