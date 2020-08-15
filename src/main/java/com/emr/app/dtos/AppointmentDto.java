package com.emr.app.dtos;

import java.util.Date;

public class AppointmentDto {

	private String appointmentId;
	private Date date;
	private UserDto assignedTo;
	private boolean acknowledged;

	public AppointmentDto() {
	}

	public AppointmentDto(Date date, UserDto assignedTo, boolean acknowledged) {
		super();
		this.date = date;
		this.assignedTo = assignedTo;
		this.acknowledged = acknowledged;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserDto getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(UserDto assignedTo) {
		this.assignedTo = assignedTo;
	}

	public boolean isAcknowledged() {
		return acknowledged;
	}

	public void setAcknowledged(boolean acknowledged) {
		this.acknowledged = acknowledged;
	}
}