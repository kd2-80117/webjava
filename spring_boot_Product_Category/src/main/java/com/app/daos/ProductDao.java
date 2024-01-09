package com.app.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.ProductDTO;
import com.app.pojos.Category;
import com.app.pojos.Product;

public interface ProductDao extends JpaRepository<Product, Long>{

	
	//add a method to find a product by name
	Optional<Product> findByName(String name);

	//ProductDTO findByCategory(String name);

	List<Product> findByCategory(Category cat);
}
