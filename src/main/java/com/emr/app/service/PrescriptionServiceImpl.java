package com.emr.app.service;

import java.io.File;

import org.springframework.stereotype.Service;

import com.emr.app.dtos.CaseDto;
import com.emr.app.dtos.PatientDto;
import com.emr.app.dtos.UserDto;
import com.emr.app.swing.views.PrescriptionView;
import com.emr.app.utilities.PDFUtil;
import com.emr.app.utilities.VelocityUtil;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Override
	public void viewPrescription(PatientDto patientDto, UserDto userDto, CaseDto caseDto) {
		PrescriptionView view = new PrescriptionView();
		view.viewPrescription(VelocityUtil.mapVelocityPatientTemplate(patientDto, userDto, caseDto));
	}

	@Override
	public boolean storePrescriptionPDF(PatientDto patientDto, UserDto userDto, CaseDto caseDto, File location) {
		boolean isSuccess = false;
		try {
			PDFUtil.convertHtmlToPDF(VelocityUtil.mapVelocityPatientTemplate(patientDto, userDto, caseDto), location);
			isSuccess = true;
		} catch (Exception e) {
		}
		return isSuccess;
	}

}