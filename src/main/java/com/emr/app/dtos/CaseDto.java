package com.emr.app.dtos;

import java.util.Date;
import java.util.List;

public class CaseDto {

	private String caseId;
	private List<String> chiefComplaints;
	private String diagnosis;
	private Vitals vitals;
	private List<MedicineAdviceDto> medicineAdvices;
	private List<String> examinationAdvices;
	private Date createdAt;
	private Date lastModified;
	private UserDto caseHandledBy;
	private Status status;

	public CaseDto() {

	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
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

	public List<MedicineAdviceDto> getMedicineAdvices() {
		return medicineAdvices;
	}

	public void setMedicineAdvices(List<MedicineAdviceDto> medicineAdvices) {
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public UserDto getCaseHandledBy() {
		return caseHandledBy;
	}

	public void setCaseHandledBy(UserDto caseHandledBy) {
		this.caseHandledBy = caseHandledBy;
	}
}