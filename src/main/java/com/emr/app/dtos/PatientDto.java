package com.emr.app.dtos;

public class PatientDto {

	private String patientId;
	private String name;
	private int age;
	private String contactNo;
	private String email;
	private String gender;
	private String address;
	private CaseDto caseDto;
	private AppointmentDto appointmentDto;

	public PatientDto() {
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

	public CaseDto getCaseDto() {
		return caseDto;
	}

	public void setCaseDto(CaseDto caseDto) {
		this.caseDto = caseDto;
	}

	public AppointmentDto getAppointmentDto() {
		return appointmentDto;
	}

	public void setAppointmentDto(AppointmentDto appointment) {
		this.appointmentDto = appointment;
	}
}