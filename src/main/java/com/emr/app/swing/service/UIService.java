package com.emr.app.swing.service;

import java.io.File;
import java.util.List;
import java.util.Set;

import com.emr.app.dtos.CaseDto;
import com.emr.app.dtos.MedicineInventoryDto;
import com.emr.app.dtos.PatientDto;
import com.emr.app.dtos.UserDto;

public interface UIService {

	public void startUIComponents();

	public List<PatientDto> getAllActiveAppointments();

	public PatientDto createAppointment(PatientDto patientAppointment) throws Exception;

	public List<PatientDto> searchExistingPatient(String patientId, String name, String contactNo);

	public List<UserDto> getAllDoctors();

	public List<CaseDto> getAllCasesForPatient(PatientDto patientDto);

	public PatientDto createCaseData(PatientDto patientDto, CaseDto caseDto) throws Exception;
	
	public Set<String> searchMedicineByPrefix(String prefix);
	
	public Set<String> searchExaminationByPrefix(String prefix);
	
	public void loadAllMedicineAndExaminationDataInMemory();

	public void viewPrescription(PatientDto patientDto, UserDto userDto, CaseDto caseDto);

	public boolean storePrescriptionPDF(PatientDto patientDto, UserDto userDto, CaseDto caseDto, File location);

	List<PatientDto> getAllPatient();

	MedicineInventoryDto storeMedicine(MedicineInventoryDto medicineInventoryDto) throws Exception;

	MedicineInventoryDto updateMedicine(MedicineInventoryDto medicineInventoryDto) throws Exception;

	List<MedicineInventoryDto> getAllMedicine();
}
