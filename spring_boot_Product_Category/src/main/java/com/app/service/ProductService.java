package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDTO;
import com.app.dto.UpdateProductDto;
import com.app.pojos.Product;

public interface ProductService {

	


	public Product getProductById(Long productId);

	

	public ApiResponse deleteProductById(Long id);

	

	public ProductDTO addNewProduct(ProductDTO product, Long categoryId);

	public List<ProductDTO> getAllProductByCategory(Long categoryId);







	public UpdateProductDto updateProductById(UpdateProductDto dto, Long categoryId);


	
	
}
