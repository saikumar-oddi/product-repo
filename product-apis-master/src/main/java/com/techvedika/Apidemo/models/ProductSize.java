package com.techvedika.Apidemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name="products_size")
public class ProductSize {

	 @JsonBackReference
	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
	@Column(name="size")
	private String size;
	
	@Column(name="count")
	private int count;
	
	@Id
	@Column(name="pro_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int proId;
	
	@ManyToOne
	@JoinColumn(name = "p_id",referencedColumnName="id", nullable=false)
	private Products products;
	
}
