package com.emr.app.dtos;

public class MedicineAdviceDto {

	private String name;
	private int days;
	private int frequency;
	private int dosage;

	public MedicineAdviceDto() {

	}

	public MedicineAdviceDto(String name, int days, int frequency, int dosage) {
		super();
		this.name = name;
		this.days = days;
		this.frequency = frequency;
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

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getDosage() {
		return dosage;
	}

	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
}