package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Appointment extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name="doctor_id",nullable = false)
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="patient_id",nullable = false)
	private Patient patient;
	
	@FutureOrPresent
	private LocalDateTime appointmentTime;

	public Appointment(Doctor doctor, Patient patient, LocalDateTime appointmentTime) {
		this.doctor = doctor;
		this.patient = patient;
		this.appointmentTime = appointmentTime;
	}
	
		
}
