package com.emr.app.swing.service;

import java.util.List;

import com.emr.app.dtos.PatientDto;

public interface UIService {

	public void startUIComponents();

	public List<PatientDto> getAllActiveAppointments();

	public PatientDto getAllCasesByPatientId(String patientId);

	public void createAppointment(PatientDto patientAppointment);

	public List<PatientDto> searchExistingPatient(String patientId, String name, String contactNo);
}
