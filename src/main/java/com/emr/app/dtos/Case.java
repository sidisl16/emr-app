package com.emr.app.dtos;

import java.util.List;

public class Case {

	private String prescriptionId;
	private List<String> chiefComplaints;
	private String diagnosis;
	private Vitals vitals;
	private List<MedicineAdvice> medicineAdvices;
	private List<String> examinationAdvices;
	private Status status;

	public String getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public List<String> getChiefComplaints() {
		return chiefComplaints;
	}

	public void setChiefComplaints(List<String> chiefComplaints) {
		this.chiefComplaints = chiefComplaints;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Vitals getVitals() {
		return vitals;
	}

	public void setVitals(Vitals vitals) {
		this.vitals = vitals;
	}

	public List<MedicineAdvice> getMedicineAdvices() {
		return medicineAdvices;
	}

	public void setMedicineAdvices(List<MedicineAdvice> medicineAdvices) {
		this.medicineAdvices = medicineAdvices;
	}

	public List<String> getExaminationAdvices() {
		return examinationAdvices;
	}

	public void setExaminationAdvices(List<String> examinationAdvices) {
		this.examinationAdvices = examinationAdvices;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}	
}