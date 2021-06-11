package com.residencia.dell.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productsVO")
public class ProductsVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "prod_id")
	private Integer prod_id;

	@Column(name = "title")
	private String title;

	@Column(name = "price")
	private Double price;

	public Integer getProd_id() {
		return prod_id;
	}

	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
