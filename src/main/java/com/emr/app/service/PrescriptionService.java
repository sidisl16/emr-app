package com.emr.app.service;

import java.io.File;

import com.emr.app.dtos.CaseDto;
import com.emr.app.dtos.PatientDto;
import com.emr.app.dtos.UserDto;

public interface PrescriptionService {
	public void viewPrescription(PatientDto patientDto, UserDto userDto, CaseDto caseDto);
	public boolean storePrescriptionPDF(PatientDto patientDto, UserDto userDto, CaseDto caseDto, File location);
}
