package com.emr.app.service;

import java.util.List;

import com.emr.app.dtos.PatientDto;

public interface PatientService {

	PatientDto storeAppointmentForPatient(PatientDto patientDto) throws Exception;

	List<PatientDto> getAllActiveAppointmentsForUser();

	List<PatientDto> searchExistingCustomer(String patientId, String name, String contactNo);

	List<PatientDto> getAllPatient();
}
