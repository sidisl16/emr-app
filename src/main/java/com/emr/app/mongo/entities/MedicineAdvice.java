package com.emr.app.mongo.entities;

public class MedicineAdvice {

	private String name;
	private int days;
	private String dosageDirection;
	private int dosage;

	public MedicineAdvice() {

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getDosageDirection() {
		return dosageDirection;
	}

	public void setDosageDirection(String dosageDirection) {
		this.dosageDirection = dosageDirection;
	}

	public int getDosage() {
		return dosage;
	}

	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
}