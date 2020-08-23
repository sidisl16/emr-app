package com.emr.app.service;

import java.io.File;

import org.springframework.stereotype.Service;

import com.emr.app.dtos.CaseDto;
import com.emr.app.dtos.PatientDto;
import com.emr.app.dtos.UserDto;
import com.emr.app.swing.views.PrescriptionView;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	public void viewPrescription(PatientDto patientDto, UserDto userDto, CaseDto caseDto) {
		PrescriptionView view = new PrescriptionView();
		view.viewPrescription("<p>testing 123..</p>");
	}

	public boolean storePrescriptionPDF(PatientDto patientDto, UserDto userDto, CaseDto caseDto, File location) {
		return false;
	}
	
	
	private String velocityTemplateMapper(PatientDto patientDto, UserDto userDto, CaseDto caseDto) {
		
		return null;
	}
	
}
