package com.emr.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.app.dtos.CaseDto;
import com.emr.app.dtos.PatientDto;
import com.emr.app.mongo.entities.Case;
import com.emr.app.mongo.repositories.CaseRepository;
import com.emr.app.utilities.EntityAndDtoConversionUtil;

@Service
public class CaseServiceImpl implements CaseService {

	@Autowired
	private CaseRepository caseRepository;

	@Override
	public List<CaseDto> getAllCasesByPatient(PatientDto patientDto) {
		List<CaseDto> cases = new ArrayList<>();
		List<Case> casesFromDb = caseRepository.findByPatientOrderByCreatedAtDesc(patientDto.getPatientId());
		if (casesFromDb != null && !casesFromDb.isEmpty()) {
			casesFromDb.stream().forEach(patientCase -> {
				CaseDto caseDto = EntityAndDtoConversionUtil.convert(patientCase, CaseDto.class);
				caseDto.setCaseId(patientCase.getId().toString());
				cases.add(caseDto);
			});
		}
		return cases;
	}
}
