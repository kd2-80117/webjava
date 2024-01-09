package com.app.dto;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.app.pojos.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
	@JsonProperty(access = Access.READ_ONLY)
	
	private Long id;
	@NotBlank(message = "product name cannot be empty")
	private String name;
	private String description;
	@Min(value = 500,message = "price should be greater than 500")
	private double price;
	private int availableStock;
	@Future(message = "expiry date should be in future")
	private LocalDate expiryDate;
	
}
