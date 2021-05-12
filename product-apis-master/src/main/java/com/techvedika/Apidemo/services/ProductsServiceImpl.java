package com.techvedika.Apidemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.techvedika.Apidemo.exceptions.EntityExistsException;
import com.techvedika.Apidemo.exceptions.UserNotFoundException;
import com.techvedika.Apidemo.models.Products;
import com.techvedika.Apidemo.repositories.ProductsRepository;

@Service
public class ProductsServiceImpl {

	@Autowired
	private ProductsRepository productsRepository;
	
	public ResponseEntity<Object> deletebyBrand(String brand){
			productsRepository.deleteByBrand(brand);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted brand : "+brand);
	}

	 public Products getProductByProductName(String productName) {
	        Optional<Products> optionalUser = productsRepository.findByProductName(productName);
	        if(optionalUser.isPresent()) {
	            return optionalUser.get();
	        } else {
	            throw new UserNotFoundException(String.format("product is not found with the given id %s", productName));
	        }
	    }
	 public Products createProduct(Products product) {
	        Optional<Products> optionalproduct = productsRepository.findByProductName(product.getProductName());
	        if (optionalproduct.isPresent()) {
	            throw new EntityExistsException(String.format("product already exist with  Id %s", product.getProductName()));
	        } else {
	           // log.info("New product created successfully");
	            return productsRepository.save(product);
	        }
	    }

	public Iterable<Products> findAll() {
		 return productsRepository.findAll();
	}
	
	public List<Products> getAllProducts(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		 
        Page<Products> pagedResult = productsRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Products>();
        }
    }

	

		public Products updateProduct(Products product) {
			return productsRepository.save(product);
		}
}

