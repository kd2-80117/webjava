package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.CategoryDao;
import com.app.dto.CategoryDTO;
import com.app.pojos.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDTO addNewCategory(CategoryDTO category) {
		Category c=categoryDao.save(mapper.map(category, Category.class));
		return mapper.map(c, CategoryDTO.class);
	}
}
