package com.residencia.dell.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private Integer orderId;

	@Column(name = "orderdate")
	private Calendar orderDate;

	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "customerid", referencedColumnName = "customerid")
	private Customers customer;

	@Column(name = "netamount")
	private BigDecimal netAmount;

	@Digits(integer = 4, fraction = 2, message = "Corrija numero de digitos")
	@DecimalMax(value = "10000", inclusive = false, message = "Tem que ser menor que 10000")
	@Column(name = "tax", nullable = false, length = 3)
	private BigDecimal tax;

	@Column(name = "totalamount")
	private BigDecimal totalAmount;

	@OneToMany(mappedBy = "orders")
	@JsonManagedReference
	private List<Orderlines> listOrderLines;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Orderlines> getListOrderLines() {
		return listOrderLines;
	}

	public void setListOrderLines(List<Orderlines> listOrderlines) {
		this.listOrderLines = listOrderLines;
	}
}
