package com.emr.app.swing.service;

import java.util.List;

import com.emr.app.dtos.PatientDto;

public interface UIService {
	
	public void startUIComponents();
	public List<PatientDto> getAllActivePatients();
}
