package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {
	
	@Column(nullable = false,unique = true)
	private String name;
	private String description;
	
}
