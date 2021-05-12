package com.techvedika.Apidemo.repositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.techvedika.Apidemo.models.ProductSize;

@Repository
public interface ProductSizeRepository extends PagingAndSortingRepository<ProductSize, Integer>{
	
}
