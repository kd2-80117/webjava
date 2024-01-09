package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.NahiMila;
import com.app.daos.CategoryDao;
import com.app.daos.ProductDao;
import com.app.dto.ApiResponse;
import com.app.dto.ProductDTO;
import com.app.dto.UpdateProductDto;
import com.app.pojos.Category;
import com.app.pojos.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	@Override
	public ApiResponse deleteProductById(Long id) {
		if(productDao.existsById(id))
		{
			productDao.deleteById(id);
			return new ApiResponse("successfully deleted id "+id) ;
		}	
		return new ApiResponse("Cannot delete Product as Id "+id+" does not exist."); 	
	}

	

	//@Override
//	public List<ProductDTO> getAllProductByCategory(String category) {
//		Category cat=categoryDao.findByName(category);
//		
//		return productDao.findByCategory(category)
//				.stream()
//				.map(p->mapper.map(p, ProductDTO.class))
//				.collect(Collectors.toList());
//	}
	
	
	
	

	@Override
	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO addNewProduct(ProductDTO product, Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
//	public List<ProductDTO> getAllProductsByCategoryId(Long categoryId) {
//		
//		List<Product> list = productDao.findByCategory(category);
//		return list.stream().map(p->mapper.map(list, ProductDTO.class))
//				.collect(Collectors.toList());
//	}

	@Override
	public List<ProductDTO> getAllProductByCategory(Long categoryId) {
		Category cat=categoryDao.findById(categoryId).orElseThrow();
		
		return productDao.findByCategory(cat)
				.stream().map(p->mapper.map(p, ProductDTO.class))
				.collect(Collectors.toList());
	}



	
	@Override
	public UpdateProductDto updateProductById(UpdateProductDto dto,Long categoryId) {
		Product p= productDao.findById(categoryId).orElseThrow();
		p.setPrice(dto.getPrice());
		return mapper.map(p, UpdateProductDto.class);
	}

	
	
}
