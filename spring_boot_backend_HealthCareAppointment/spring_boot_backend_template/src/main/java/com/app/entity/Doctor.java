package com.app.entity;

import javax.persistence.Entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Doctor extends BaseEntity{
	
	
	private String name;
	private String specialization;

}
