package com.emr.app.dtos;

import java.util.Date;

public class Appointment {

	private Date date;
	private User assignedTo;
	private boolean acknowledged;

	public Appointment() {
	}

	public Appointment(Date date, User assignedTo, boolean acknowledged) {
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

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public boolean isAcknowledged() {
		return acknowledged;
	}

	public void setAcknowledged(boolean acknowledged) {
		this.acknowledged = acknowledged;
	}
}