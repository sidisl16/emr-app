package com.emr.app.service;

import java.util.List;

import com.emr.app.dtos.CaseDto;
import com.emr.app.dtos.PatientDto;

public interface CaseService {

	List<CaseDto> getAllCasesByPatient(PatientDto patientDto);

	PatientDto storeCaseData(PatientDto patientDto, CaseDto caseDto) throws Exception;

}
