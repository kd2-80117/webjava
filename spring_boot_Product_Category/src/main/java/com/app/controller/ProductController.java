package com.app.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDTO;
import com.app.dto.UpdateProductDto;
import com.app.pojos.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {
	public ProductController() {
		System.out.println("in ctor "+getClass());
	}
	
	@Autowired
	public ProductService productService; 
	
	
	
	//URL: http://host:port/products/category/{categoryId}
	@PostMapping("/category/{categoryId}")
	public ProductDTO addNewProduct(@RequestBody @Valid ProductDTO product,@PathVariable @NotNull Long categoryId) {
		System.out.println("in addNewProduct"+product);
		return productService.addNewProduct(product,categoryId);
	}
	
	
	@GetMapping("/category/{categoryId}")
	public List<ProductDTO> getProductDetailsByCategoryId(@PathVariable Long categoryId){
		return productService.getAllProductByCategory(categoryId);
	}
	
	//@GetMapping("/category/{category}")
	//public List<ProductDTO> getAllProductsByCategory(@PathVariable String category){
		//return productService.getAllProductsByCategory(category);
	//}
	
	
	//URL: http://localhost:port/ctx_path/product/productId
	@DeleteMapping("/{id}")
	public ApiResponse deleteProductById(@PathVariable Long id) {
		return productService.deleteProductById(id);
		
	}
	
	//URL: http://host:port/ctx_path/product/productId
	@PutMapping("/{id}")
	public UpdateProductDto updateProductById(@RequestBody UpdateProductDto dto,@PathVariable Long id) {
		return productService.updateProductById(dto,id);
	}
}
