package com.techvedika.Apidemo.repositories;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.techvedika.Apidemo.models.Products;


@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Products, Integer> {

	Optional<Products> findByProductName(String brand);

	@Transactional
	void deleteByBrand(String brand);

	Object findByBrand(String brand);

	@Transactional
	@Modifying
	@Query("UPDATE Products p SET p.brand = :bn WHERE p.brand = :bo")
	int updateProduct(@Param("bn")String b1,@Param("bo")String b2);

	}

