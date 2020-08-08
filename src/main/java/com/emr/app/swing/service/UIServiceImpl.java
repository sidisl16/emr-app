package com.emr.app.swing.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.emr.app.dtos.Appointment;
import com.emr.app.dtos.PatientDto;
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
	public void createAppointment(PatientDto patientAppointment) {

	}

	@Override
	public List<PatientDto> searchExistingPatient(PatientDto patientAppointment) {
		return null;
	}

}
