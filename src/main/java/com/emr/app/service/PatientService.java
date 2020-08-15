package com.emr.app.service;

import com.emr.app.dtos.PatientDto;

public interface PatientService {

	PatientDto storeAppointmentForPatient(PatientDto patientDto) throws Exception;
}
