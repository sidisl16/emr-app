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
	private List<CaseDto> prescriptionList;
	private AppointmentDto appointment;

	public PatientDto() {
	}

	public PatientDto(String patientId, String name, int age, String contactNo, String email, String gender,
			String address, List<CaseDto> prescriptionList, AppointmentDto appointment) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.contactNo = contactNo;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.prescriptionList = prescriptionList;
		this.appointment = appointment;
	}

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

	public List<CaseDto> getPrescriptionList() {
		return prescriptionList;
	}

	public void setPrescriptionList(List<CaseDto> prescriptionList) {
		this.prescriptionList = prescriptionList;
	}

	public AppointmentDto getAppointmentDto() {
		return appointment;
	}

	public void setAppointmentDto(AppointmentDto appointment) {
		this.appointment = appointment;
	}
}