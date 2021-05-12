package com.techvedika.Apidemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techvedika.Apidemo.models.ProductSize;
import com.techvedika.Apidemo.services.ProductSizeServiceImpl;

@RestController
public class ProductSizeController {

	 @Autowired
	    private ProductSizeServiceImpl productSizeService;

	    @PostMapping("/addproductsize")
	    public ResponseEntity<ProductSize> addSize(@RequestBody ProductSize productSize) {
	        return new ResponseEntity<ProductSize>(productSizeService.saveorUpadteSize(productSize), HttpStatus.CREATED);
	    }

	    @GetMapping("/getallproductsizes")
	    public ResponseEntity<List<ProductSize>> getAllEmployees(
                @RequestParam(defaultValue = "0") Integer pageNo, 
                @RequestParam(defaultValue = "10") Integer pageSize) {
				List<ProductSize> list = productSizeService.getAllProductSizes(pageNo, pageSize);
				
				return new ResponseEntity<List<ProductSize>>(list, new HttpHeaders(), HttpStatus.OK); 
		}
	
}
