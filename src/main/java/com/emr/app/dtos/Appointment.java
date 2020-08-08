package com.emr.app.dtos;

import java.util.Date;

public class Appointment {

	private Date date;
	private User assignedTo;
	private Status status;

	public Appointment() {
	}

	public Appointment(Date date, User assignedTo) {
		super();
		this.date = date;
		this.assignedTo = assignedTo;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}