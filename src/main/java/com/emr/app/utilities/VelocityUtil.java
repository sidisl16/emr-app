package com.emr.app.utilities;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.emr.app.dtos.CaseDto;
import com.emr.app.dtos.PatientDto;
import com.emr.app.dtos.UserDto;

public class VelocityUtil {

	// Variables to display clinic data
	public static final String CLINIC_NAME = "clinicname";
	public static final String PRESCRIPTION_DATE = "date";
	public static final String CLINIC_CONTACT = "cliniccontact";

	// Variables to display patient details
	public static final String PATIENT_NO = "patno";
	public static final String PATIENT_NAME = "patname";
	public static final String PATIENT_AGE = "patage";
	public static final String PATIENT_GENDER = "patgender";
	public static final String PATIENT_CONTACT = "patcontact";

	// Variables to display patient vitals
	public static final String PULSE_RATE = "pulserate";
	public static final String BP_SYSTOLIC = "bpsys";
	public static final String BP_DIASTOLIC = "bpdias";
	public static final String TEMPERATURE = "temp";
	public static final String HEIGHT = "height";
	public static final String WEIGHT = "weight";
	public static final String BMI = "bmi";

	public static final String CHIEF_COMPLAINTS = "chiefcomplaints";
	public static final String DIAGNOSIS = "diagnosis";
	public static final String MEDICINE_ADVICE = "medicineadvice";
	public static final String EXAMINATIONS = "examinations";

	public static String mapVelocityTemplate(PatientDto patientDto, UserDto userDto, CaseDto caseDto) {
		StringWriter writer = new StringWriter();
		try {
			VelocityEngine velocityEngine = new VelocityEngine();
			velocityEngine.init();
			Template t = velocityEngine.getTemplate("src/main/resources/velocity-template/prescription.vm", "UTF-8");
			t.merge(getVelocityContext(patientDto, userDto, caseDto), writer);
		} catch (Exception e) {
		}
		return writer.toString();
	}

	private static VelocityContext getVelocityContext(PatientDto patientDto, UserDto userDto, CaseDto caseDto) {
		VelocityContext context = new VelocityContext();
		context.put(CLINIC_NAME, "");
		context.put(PRESCRIPTION_DATE, DateUtil.formatDate(caseDto.getLastModified()));
		context.put(CLINIC_CONTACT, "");
		context.put(PATIENT_NO, patientDto.getPatientId());
		context.put(PATIENT_NAME, patientDto.getName());
		context.put(PATIENT_AGE, patientDto.getAge());
		context.put(PATIENT_GENDER, patientDto.getGender());
		// context.put(PATIENT_CONTACT, value);
		context.put(PULSE_RATE, caseDto.getVitals().getPulserate());
		context.put(BP_SYSTOLIC, caseDto.getVitals().getBpSystolic());
		context.put(BP_DIASTOLIC, caseDto.getVitals().getBpDistolic());
		context.put(TEMPERATURE, caseDto.getVitals().getTemp());
		context.put(HEIGHT, caseDto.getVitals().getHeight());
		context.put(WEIGHT, caseDto.getVitals().getWeight());
		context.put(BMI, caseDto.getVitals().getBmi());
		context.put(CHIEF_COMPLAINTS,
				caseDto.getChiefComplaints() == null || caseDto.getChiefComplaints().isEmpty() ? null
						: caseDto.getChiefComplaints());
		context.put(DIAGNOSIS, caseDto.getDiagnosis());
		context.put(MEDICINE_ADVICE, caseDto.getMedicineAdvices());
		context.put(EXAMINATIONS,
				caseDto.getExaminationAdvices() == null || caseDto.getExaminationAdvices().isEmpty() ? null
						: caseDto.getExaminationAdvices());
		return context;
	}
}
