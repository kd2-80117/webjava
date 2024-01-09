package com.app.service;

import java.util.List;

import com.app.dto.AppointmentDTO;
import com.app.entity.Appointment;

public interface AppointmentService {

	String addAppointment(AppointmentDTO dto);

	String deleteAppointment(Long appId);

	List<Appointment> getAppointmentDetails(Long doctorId);

}
