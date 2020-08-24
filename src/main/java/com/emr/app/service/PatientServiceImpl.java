package com.emr.app.service;

import java.util.ArrayList;
import java.util.Date;
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

	private static final String PATIENT_NO_PREFIX = "PAT-";

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
				patient.setLastModified(new Date());
			}
		} else {
			patient.setCreatedOn(new Date());
			patient.setLastModified(new Date());
		}
		patient.setPatientId(PATIENT_NO_PREFIX + System.currentTimeMillis());
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

	@Override
	public List<PatientDto> getAllActiveAppointmentsForUser() {
		List<PatientDto> patientAppointments = new ArrayList<>();
		List<Appointment> appointments = appointmentRepository.findByAcknowledgedOrderByDateAsc(false);
		appointments.stream().forEach(appointment -> {
			PatientDto patientDto = EntityAndDtoConversionUtil.convert(appointment.getPatient(), PatientDto.class);
			AppointmentDto appointmentDto = EntityAndDtoConversionUtil.convert(appointment, AppointmentDto.class);
			appointmentDto.setAppointmentId(appointment.getId().toString());
			patientDto.setAppointmentDto(appointmentDto);
			patientAppointments.add(patientDto);
		});
		return patientAppointments;
	}

	@Override
	public List<PatientDto> searchExistingCustomer(String patientId, String name, String contactNo) {
		List<PatientDto> patients = new ArrayList<>();
		if (!Strings.isNullOrEmpty(patientId)) {
			Optional<Patient> optionalPatient = patientRepository.findByPatientId(patientId);
			if (optionalPatient.isPresent()) {
				patients.add(EntityAndDtoConversionUtil.convert(optionalPatient.get(), PatientDto.class));
				return patients;
			}
		}

		if (!Strings.isNullOrEmpty(name) || !Strings.isNullOrEmpty(contactNo)) {
			List<Patient> patientsFromDb = patientRepository
					.findByNameOrContactNoOrderByName(Strings.isNullOrEmpty(name) ? "" : name, contactNo);
			patientsFromDb.stream()
					.forEach(patient -> patients.add(EntityAndDtoConversionUtil.convert(patient, PatientDto.class)));
		}
		return patients;
	}

	@Override
	public List<PatientDto> getAllPatient() {
		List<PatientDto> patients = new ArrayList<>();
		patientRepository.findAllOrderByName().forEach(patient -> {
			patients.add(EntityAndDtoConversionUtil.convert(patient, PatientDto.class));
		});
		return patients;
	}

}
