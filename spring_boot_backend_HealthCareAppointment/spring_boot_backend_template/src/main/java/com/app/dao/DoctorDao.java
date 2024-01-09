package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Doctor;

public interface DoctorDao extends JpaRepository<Doctor, Long> {

}
