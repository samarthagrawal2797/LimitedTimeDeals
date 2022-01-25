package com.udaaninterview.limitedtimedeals.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "deal")
@NoArgsConstructor
public class Deal {
	@Column
	private Integer product_id;
	
	@Id
	@Column(unique = true, nullable = false)
	private String name;
	
	@Column
	private Integer quantity;
	
	@Column
	private Long validUpto;
	
	@Column
	private Double price;
	
	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Long validUpto) {
		this.validUpto = validUpto;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



	public Deal(Integer product_id, String name, Integer quantity, Double price, Long validUpto) {
		super();
		this.product_id = product_id;
		this.quantity = quantity;
		this.price = price;
		this.validUpto = validUpto;
		this.name = name;
	}

	public Deal() {
		super();
	}
	
	
	
	
}
