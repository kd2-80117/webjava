package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="products")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product extends BaseEntity {
	@Column(unique = true)
	private String name;
	private String description;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	private double price;
	private int availableStock;
	private LocalDate expiryDate;


	
}
