package com.emr.app.swing.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.emr.app.dtos.Appointment;
import com.emr.app.dtos.Case;
import com.emr.app.dtos.PatientDto;
import com.emr.app.dtos.Status;
import com.emr.app.dtos.UserDto;
import com.emr.app.swing.views.HomeScreen;

@Service
public class UIServiceImpl implements UIService {

	private static final Logger logger = Logger.getLogger(UIServiceImpl.class.getName());

	@Override
	public void startUIComponents() {
		HomeScreen.startUIComponent(this);
	}

	@Override
	public List<PatientDto> getAllActiveAppointments() {
		logger.log(Level.INFO, "get all appointments");
		List<PatientDto> list = new ArrayList<>();
		list.add(new PatientDto(("PAT-" + System.currentTimeMillis()), "Siddharth Kumar", 30, "9742648307",
				"sidisl16@gmail.com", "Male", "ISM Dhanbad", null, new Appointment(new Date(), null, false)));
		list.add(new PatientDto(("PAT-" + System.currentTimeMillis()), "Jimmy Kumar", 22, "7252834522",
				"jimmyKumar312@gmail.com", "Male", "Binod Nagar Dhanbad", null,
				new Appointment(new Date(), null, false)));
		return list;
	}

	@Override
	public PatientDto getAllCasesByPatientId(String patientId) {

		return new PatientDto(("PAT-" + System.currentTimeMillis()), "Jimmy Kumar", 22, "7252834522",
				"jimmyKumar312@gmail.com", "Male", "Binod Nagar Dhanbad", null,
				new Appointment(new Date(), null, false));
	}

	@Override
	public PatientDto createAppointment(PatientDto patientAppointment) {
		return patientAppointment;
	}

	@Override
	public List<PatientDto> searchExistingPatient(String patientId, String name, String contactNo) {
		List<PatientDto> list = new ArrayList<>();
		list.add(new PatientDto(("PAT-" + System.currentTimeMillis()), "Siddharth Kumar", 30, "9742648307",
				"sidisl16@gmail.com", "Male", "ISM Dhanbad", null, new Appointment(new Date(), null, false)));
		list.add(new PatientDto(("PAT-" + System.currentTimeMillis()), "Jimmy Kumar", 22, "7252834522",
				"jimmyKumar312@gmail.com", "Male", "Binod Nagar Dhanbad", null,
				new Appointment(new Date(), null, false)));
		return list;
	}

	@Override
	public List<UserDto> getAllDoctors() {
		List<UserDto> list = new ArrayList<>();
		list.add(new UserDto("Vikash", "", ""));
		list.add(new UserDto("Siddharth", "", ""));
		return list;
	}

	@Override
	public List<Case> getAllCasesForPatient(PatientDto patientDto) {
		List<Case> list = new ArrayList<>();
		list.add(new Case(null, null, null, null, null, null, new Date(), new Date(), Status.ACTIVE));
		return list;
	}

}
