package com.emr.app.dtos;

public class MedicineAdviceDto {

	private String name;
	private int days;
	private String dosageDirection;
	private int dosage;

	public MedicineAdviceDto() {

	}

	public MedicineAdviceDto(String name, int days, String  dosageDirection, int dosage) {
		super();
		this.name = name;
		this.days = days;
		this.dosageDirection = dosageDirection;
		this.dosage = dosage;
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