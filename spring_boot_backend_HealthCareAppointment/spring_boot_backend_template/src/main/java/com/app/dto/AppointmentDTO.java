package com.app.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AppointmentDTO {

	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@NotNull
	private Long patientId;
	
	@NotNull
	private Long doctorId;
	
	@FutureOrPresent
	LocalDateTime appTime;
	
	
}
