package com.app.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Appointment;
import com.app.entity.Doctor;
import com.app.entity.Patient;

public interface AppointmentDao extends JpaRepository<Appointment, Long> {


	List<Appointment> findByDoctor(Doctor doc);

	public Boolean existsByAppointmentTimeAndDoctor(LocalDateTime appTime, Doctor d);
	public Boolean existsByAppointmentTimeAndPatient(LocalDateTime appTime, Patient p);
}
