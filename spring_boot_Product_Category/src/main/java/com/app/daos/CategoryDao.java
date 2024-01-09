package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Category;

public interface CategoryDao extends JpaRepository<Category, Long>{

	Category findByName(String category);

}
