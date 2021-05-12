package com.techvedika.Apidemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techvedika.Apidemo.models.ProductSize;
import com.techvedika.Apidemo.repositories.ProductSizeRepository;

@Service
public class ProductSizeServiceImpl {
		
		 @Autowired
		    private ProductSizeRepository productSizeRepository;

		 public ProductSize saveorUpadteSize(ProductSize productSize) {
		        return productSizeRepository.save(productSize);
		    }

		public Iterable<ProductSize> findAll() {
			
			 return productSizeRepository.findAll();
			
		}

		public List<ProductSize> getAllProductSizes(Integer pageNo, Integer pageSize) {
			 Pageable paging = PageRequest.of(pageNo, pageSize);
			 
		        Page<ProductSize> pagedResult = productSizeRepository.findAll(paging);
		         
		        if(pagedResult.hasContent()) {
		            return pagedResult.getContent();
		        } else {
		            return new ArrayList<ProductSize>();
		        }
		    }
		}

