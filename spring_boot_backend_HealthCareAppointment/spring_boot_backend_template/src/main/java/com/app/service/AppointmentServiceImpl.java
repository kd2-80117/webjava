package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AppointmentDao;
import com.app.dao.DoctorDao;
import com.app.dao.PatientDao;
import com.app.dto.AppointmentDTO;
import com.app.entity.Appointment;
import com.app.entity.Doctor;
import com.app.entity.Patient;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDao appDao;
	
	
	@Autowired
	private DoctorDao ddao;
	
	@Autowired
	private PatientDao pdao;

	@Override
	public String addAppointment(AppointmentDTO dto) {
		
	if(ddao.existsById(dto.getDoctorId()) && pdao.existsById(dto.getPatientId())) {
			Doctor d = ddao.findById(dto.getDoctorId()).orElseThrow();
			Patient p = pdao.findById(dto.getPatientId()).orElseThrow();
		if(appDao.existsByAppointmentTimeAndDoctor(dto.getAppTime(),d)
										&&
		appDao.existsByAppointmentTimeAndPatient(dto.getAppTime(),p)) {
			return "Appointment slot is full at this time...plz try different time slot";
		}else {
			Doctor doc = ddao.findById(dto.getDoctorId()).orElseThrow();
			Patient pat = pdao.findById(dto.getPatientId()).orElseThrow();
			Appointment app = new Appointment(doc, pat, dto.getAppTime());
			appDao.save(app);
			return "Appointment confirmed and appointment id = "+app.getId();
		}
	}
		return "Appointment confirmation failed as invalid id";
	}

	@Override
	public String deleteAppointment(Long appId) {
		appDao.deleteById(appId);
		return "Appointment deleted successfully";
	}

	@Override
	public List<Appointment> getAppointmentDetails(Long doctorId) {
		 Doctor doc =ddao.findById(doctorId).orElseThrow();
		return appDao.findByDoctor(doc);
	}

}
