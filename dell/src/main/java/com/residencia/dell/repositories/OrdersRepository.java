package com.residencia.dell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.dell.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
