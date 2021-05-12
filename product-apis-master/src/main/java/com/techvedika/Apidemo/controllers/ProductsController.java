package com.techvedika.Apidemo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techvedika.Apidemo.models.Products;
import com.techvedika.Apidemo.repositories.ProductsRepository;
import com.techvedika.Apidemo.services.ProductsServiceImpl;

@RestController
public class ProductsController {

	@Autowired
	private ProductsRepository productRepository;
	
	 @Autowired
	 private ProductsServiceImpl productsService;
	
	@PostMapping("/product/create")
    public Products createProduct(@RequestBody Products product) {
        return  productsService.createProduct(product);
    }
		
    @GetMapping("/product/getallproducts")
    public ResponseEntity<List<Products>> getAllProducts(
                        @RequestParam(defaultValue = "0") Integer pageNo, 
                        @RequestParam(defaultValue = "10") Integer pageSize) 
    {
        List<Products> list = productsService.getAllProducts(pageNo, pageSize);
 
        return new ResponseEntity<List<Products>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
    
	 @GetMapping("/{productName}")
	    public Products getProductByProductName(@PathVariable final String productName) {
	        return productsService.getProductByProductName(productName);
	}
	
	 @GetMapping("/{b1}/{b2}")
	 public int updateProduct(@PathVariable String b1, @PathVariable String b2)
	 	{
		  return productRepository.updateProduct(b1,b2);
	 	}
	 
	 @DeleteMapping("/products/{brand}")
		public ResponseEntity<Object> deletebyBrand(@PathVariable(value = "brand") String brand){
				return productsService.deletebyBrand(brand) ;
				
		}
}