package com.emr.app.dtos;

public class Vitals {

	private Float pulserate;
	private Float bpSystolic;
	private Float bpDistolic;
	private Float temp;
	private Float height;
	private Float weight;
	private Float bmi;

	public Float getPulserate() {
		return pulserate;
	}

	public void setPulserate(Float pulserate) {
		this.pulserate = pulserate;
	}

	public Float getBpSystolic() {
		return bpSystolic;
	}

	public void setBpSystolic(Float bpSystolic) {
		this.bpSystolic = bpSystolic;
	}

	public Float getBpDistolic() {
		return bpDistolic;
	}

	public void setBpDistolic(Float bpDistolic) {
		this.bpDistolic = bpDistolic;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float temp) {
		this.temp = temp;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getBmi() {
		return bmi;
	}

	public void setBmi(Float bmi) {
		this.bmi = bmi;
	}
}