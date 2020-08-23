package com.emr.app.mongo.entities;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "case")
public class Case {

	@Id
	private ObjectId id;

	@DBRef
	private Patient patient;
	private List<String> chiefComplaints;
	private String diagnosis;
	private Vitals vitals;
	private List<MedicineAdvice> medicineAdvices;
	private List<String> examinationAdvices;
	private Date createdAt;
	private Date lastModified;
	private User caseHandledBy;
	private Status status;

	public Case() {

	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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

	public User getCaseHandledBy() {
		return caseHandledBy;
	}

	public void setCaseHandledBy(User caseHandledBy) {
		this.caseHandledBy = caseHandledBy;
	}
}