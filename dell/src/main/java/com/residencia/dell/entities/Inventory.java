package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "prod_id")
	private Integer prod_id;

	@Column(name = "quan_in_stock")
	private Integer quan_in_stock;

	@Column(name = "sales")
	private String sales;

	public Integer getProd_id() {
		return prod_id;
	}

	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}

	public Integer getQuan_in_stock() {
		return quan_in_stock;
	}

	public void setQuan_in_stock(Integer quan_in_stock) {
		this.quan_in_stock = quan_in_stock;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}
	
}
