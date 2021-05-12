package com.techvedika.Apidemo.models;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Products {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "products", fetch = FetchType.LAZY)
    private List<ProductSize> productsize;

	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="price")
	private int price;
	
	@Column(name="available_count")
	private int availableCount;
	
	
	@Column(name="outof_stock")
	private boolean isOutOfStock;
	
	
	@JsonManagedReference
	public List<ProductSize> getProductsize() {
		return productsize;
	}



	

	

}
