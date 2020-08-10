package com.emr.app.dtos;

import java.util.Date;

public class Appointment {

	private Date date;
	private UserDto assignedTo;
	private boolean acknowledged;

	public Appointment() {
	}

	public Appointment(Date date, UserDto assignedTo, boolean acknowledged) {
		super();
		this.date = date;
		this.assignedTo = assignedTo;
		this.acknowledged = acknowledged;
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