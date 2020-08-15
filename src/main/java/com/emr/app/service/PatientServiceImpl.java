package com.emr.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emr.app.dtos.AppointmentDto;
import com.emr.app.dtos.PatientDto;
import com.emr.app.mongo.entities.Appointment;
import com.emr.app.mongo.entities.Patient;
import com.emr.app.mongo.repositories.AppointmentRepository;
import com.emr.app.mongo.repositories.PatientRepository;
import com.emr.app.utilities.EntityAndDtoConversionUtil;
import com.google.common.base.Strings;

@Service
@Transactional(readOnly = false)
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	// need users data while creating appointment
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	@Override
	@Transactional(rollbackFor = Exception.class)
	public PatientDto storeAppointmentForPatient(PatientDto patientDto) throws Exception {
		Patient patient = new Patient();
		EntityAndDtoConversionUtil.copyIgnoreNull(patientDto, patient);
		if (!Strings.isNullOrEmpty(patientDto.getPatientId())) {
			Optional<Patient> optionalPatient = patientRepository.findByPatientId(patientDto.getPatientId());
			if (optionalPatient.isPresent()) {
				patient = optionalPatient.get();
			}
		}
		patient = patientRepository.save(patient);
		AppointmentDto appointmentDto = patientDto.getAppointmentDto();
		Appointment appointment = new Appointment();
		EntityAndDtoConversionUtil.copyIgnoreNull(appointmentDto, appointment);
		appointment.setPatient(patient);
		appointment = appointmentRepository.save(appointment);
		EntityAndDtoConversionUtil.copyIgnoreNull(patient, patientDto);
		EntityAndDtoConversionUtil.copyIgnoreNull(appointment, appointmentDto);
		patientDto.setAppointmentDto(appointmentDto);
		return patientDto;
	}
	
	public List<PatientDto> getAllActiveAppointmentsForUser() {
		
		return null;
	}

}
