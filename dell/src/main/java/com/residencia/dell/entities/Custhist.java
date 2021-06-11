package com.residencia.dell.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "custhist")
public class Custhist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// pesquisar Id
//	@ManyToOne
//	@JoinColumn(name = "customerid", referencedColumnName = "customerid")
//	private Customers customer;

	@Column(name = "orderid")
	private Integer orderId;

	@Column(name = "prod_id")
	private Integer prod_Id;

//	public Customers getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customers customer) {
//		this.customer = customer;
//	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProd_Id() {
		return prod_Id;
	}

	public void setProd_Id(Integer prod_Id) {
		this.prod_Id = prod_Id;
	}

}
