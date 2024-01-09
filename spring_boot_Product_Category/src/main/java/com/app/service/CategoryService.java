package com.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.CategoryDTO;

@Service
@Transactional
public interface CategoryService {

	CategoryDTO addNewCategory(CategoryDTO category);
	
}
