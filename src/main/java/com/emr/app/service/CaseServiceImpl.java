package com.emr.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emr.app.dtos.CaseDto;
import com.emr.app.dtos.PatientDto;
import com.emr.app.mongo.entities.Case;
import com.emr.app.mongo.entities.Patient;
import com.emr.app.mongo.entities.Status;
import com.emr.app.mongo.entities.Vitals;
import com.emr.app.mongo.repositories.CaseRepository;
import com.emr.app.mongo.repositories.PatientRepository;
import com.emr.app.utilities.EntityAndDtoConversionUtil;
import com.google.common.base.Strings;

@Service
@Transactional
public class CaseServiceImpl implements CaseService {

	@Autowired
	private CaseRepository caseRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public List<CaseDto> getAllCasesByPatient(PatientDto patientDto) {
		List<CaseDto> cases = new ArrayList<>();
		Optional<Patient> optionalPatient = patientRepository.findByPatientId(patientDto.getPatientId());
		List<Case> casesFromDb = caseRepository.findByPatientId(optionalPatient.get().getId());
		if (casesFromDb != null && !casesFromDb.isEmpty()) {
			casesFromDb.stream().forEach(patientCase -> {
				CaseDto caseDto = EntityAndDtoConversionUtil.convert(patientCase, CaseDto.class);
				caseDto.setCaseId(patientCase.getId().toString());
				cases.add(caseDto);
			});
		}
		return cases;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public PatientDto storeCaseData(PatientDto patientDto, CaseDto caseDto) throws Exception {
		Optional<Patient> optionalPatient = patientRepository.findByPatientId(patientDto.getPatientId());
		if (optionalPatient.isPresent()) {
			Patient patient = optionalPatient.get();
			EntityAndDtoConversionUtil.copy(patientDto, patient);
			patient = patientRepository.save(patient);
			Case caseToPersist = new Case();
			if (!Strings.isNullOrEmpty(caseDto.getCaseId())) {
				Optional<Case> optionalPatientCase = caseRepository.findById(new ObjectId(caseDto.getCaseId()));
				if (optionalPatientCase.isPresent()) {
					caseToPersist = optionalPatientCase.get();
				}
			}
			EntityAndDtoConversionUtil.copy(caseDto, caseToPersist);
			if (caseDto.getVitals() != null) {
				caseToPersist.setVitals(EntityAndDtoConversionUtil.convert(caseDto.getVitals(), Vitals.class));
			}
			caseToPersist.setPatient(patient);
			caseToPersist.setLastModified(new Date());
			if (caseToPersist.getCreatedAt() == null) {
				caseToPersist.setCreatedAt(new Date());
			}
			if (caseDto.getStatus() == com.emr.app.dtos.Status.CLOSED) {
				caseToPersist.setStatus(Status.CLOSED);
			} else {
				caseToPersist.setStatus(Status.ACTIVE);
			}
			caseToPersist = caseRepository.save(caseToPersist);
			EntityAndDtoConversionUtil.copy(patient, patientDto);
			EntityAndDtoConversionUtil.copy(caseToPersist, caseDto);
			caseDto.setCaseId(caseToPersist.getId().toString());
			patientDto.setCaseDto(caseDto);
		} else {
			throw new Exception("Patient not found");
		}
		return patientDto;
	}
}
