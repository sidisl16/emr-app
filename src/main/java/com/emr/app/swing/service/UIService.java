package com.emr.app.swing.service;

import java.util.List;

import com.emr.app.dtos.CaseDto;
import com.emr.app.dtos.PatientDto;
import com.emr.app.dtos.UserDto;

public interface UIService {

	public void startUIComponents();

	public List<PatientDto> getAllActiveAppointments();

	public PatientDto getAllCasesByPatientId(String patientId);

	public PatientDto createAppointment(PatientDto patientAppointment);

	public List<PatientDto> searchExistingPatient(String patientId, String name, String contactNo);

	public List<UserDto> getAllDoctors();

	public List<CaseDto> getAllCasesForPatient(PatientDto patientDto);
}
