package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppointmentDTO;
import com.app.entity.Appointment;
import com.app.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appService;
	
	
	@PostMapping
	public String addAppointment(@RequestBody @Valid AppointmentDTO dto) {
		return appService.addAppointment(dto);
	}
	
	//@DeleteMapping("/{appId}")
	//public String deleteAppointment(@PathVariable Long appId) {
	//	return appService.deleteAppointment(appId);
	//}
	
	@DeleteMapping("/{appId}")
	public ResponseEntity<?> deleteAppointment(@PathVariable Long appId) {
		return ResponseEntity.ok(appService.deleteAppointment(appId));
	}
	
	//@GetMapping("/doctor/{doctorId}/upcoming")
	//public List<Appointment> getAppointmentDetails(@PathVariable Long doctorId) {
		//return appService.getAppointmentDetails(doctorId);
	//}
	
	@GetMapping("/doctor/{doctorId}/upcoming")
	public ResponseEntity<?> getAppointmentDetails(@PathVariable Long doctorId) {
		List<Appointment> list = appService.getAppointmentDetails(doctorId);
		if (list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.ok(list);
	}
	
}
