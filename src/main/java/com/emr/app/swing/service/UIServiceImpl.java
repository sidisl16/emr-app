package com.emr.app.swing.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.app.dtos.CaseDto;
import com.emr.app.dtos.MedicineInventoryDto;
import com.emr.app.dtos.PatientDto;
import com.emr.app.dtos.UserDto;
import com.emr.app.service.AutoSuggestionService;
import com.emr.app.service.CaseService;
import com.emr.app.service.InventoryService;
import com.emr.app.service.PatientService;
import com.emr.app.service.PrescriptionService;
import com.emr.app.swing.views.HomeScreen;

@Service
public class UIServiceImpl implements UIService {

	private static final Logger logger = Logger.getLogger(UIServiceImpl.class.getName());

	@Autowired
	private AutoSuggestionService autoSuggestionService;

	@Autowired
	private PatientService patientService;

	@Autowired
	private CaseService caseService;

	@Autowired
	private PrescriptionService prescriptionService;

	@Autowired
	private InventoryService inventoryService;

	@Override
	public void startUIComponents() {
		HomeScreen.startUIComponent(this);
	}

	@Override
	public List<PatientDto> getAllActiveAppointments() {
		logger.log(Level.INFO, "get all appointments");
		return patientService.getAllActiveAppointmentsForUser();
	}

	@Override
	public PatientDto createAppointment(PatientDto patientAppointment) throws Exception {
		patientAppointment = patientService.storeAppointmentForPatient(patientAppointment);
		return patientAppointment;
	}

	@Override
	public List<PatientDto> searchExistingPatient(String patientId, String name, String contactNo) {
		logger.log(Level.INFO, "Searching patient - " + patientId + " " + name + " " + contactNo);
		return patientService.searchExistingCustomer(patientId, name, contactNo);
	}

	@Override
	public List<UserDto> getAllDoctors() {
		List<UserDto> list = new ArrayList<>();
		list.add(new UserDto("Vikash", "", ""));
		list.add(new UserDto("Siddharth", "", ""));
		return list;
	}

	@Override
	public List<CaseDto> getAllCasesForPatient(PatientDto patientDto) {
		return caseService.getAllCasesByPatient(patientDto);
	}

	@Override
	public PatientDto createCaseData(PatientDto patientDto, CaseDto caseDto) throws Exception {
		return caseService.storeCaseData(patientDto, caseDto);
	}

	@Override
	public Set<String> searchMedicineByPrefix(String prefix) {
		Set<String> medicines = new HashSet<>();
		autoSuggestionService.searchMedicineByPrefix(prefix).forEach(medicine -> medicines.add(medicine.toString()));
		return medicines;
	}

	@Override
	public Set<String> searchExaminationByPrefix(String prefix) {
		return autoSuggestionService.searchExaminationByPrefix(prefix);
	}

	@Override
	public void loadAllMedicineAndExaminationDataInMemory() {
		autoSuggestionService.loadAllMedicineAndExaminationDataInMemory();
	}

	@Override
	public void viewPrescription(PatientDto patientDto, UserDto userDto, CaseDto caseDto) {
		prescriptionService.viewPrescription(patientDto, userDto, caseDto);
	}

	@Override
	public boolean storePrescriptionPDF(PatientDto patientDto, UserDto userDto, CaseDto caseDto, File location) {
		return prescriptionService.storePrescriptionPDF(patientDto, userDto, caseDto, location);
	}

	@Override
	public List<PatientDto> getAllPatient() {
		return patientService.getAllPatient();
	}
	
	@Override
	public MedicineInventoryDto storeMedicine(MedicineInventoryDto medicineInventoryDto) throws Exception {
		return inventoryService.addMedicine(medicineInventoryDto);
	}

	@Override
	public MedicineInventoryDto updateMedicine(MedicineInventoryDto medicineInventoryDto) throws Exception {
		return inventoryService.updateMedicine(medicineInventoryDto);
	}
	
	@Override
	public List<MedicineInventoryDto> getAllMedicine() {
		return inventoryService.getAllMedicine();
	}
}