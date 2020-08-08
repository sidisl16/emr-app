package com.emr.app.dtos;

import java.util.List;

public class PatientDto {

	private String patientId;
	private String name;
	private int age;
	private String contactNo;
	private String email;
	private String gender;
	private String address;
	private List<Prescription> prescriptionList;

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Prescription> getPrescriptionList() {
		return prescriptionList;
	}

	public void setPrescriptionList(List<Prescription> prescriptionList) {
		this.prescriptionList = prescriptionList;
	}
}