package com.emr.app.dtos;

public class Vitals {
	
	private float pulserate;
	private float bpSystolic;
	private float bpDistolic;
	private float temp;
	private float height;
	private float weight;
	private float bmi;
	
	public float getPulserate() {
		return pulserate;
	}
	public void setPulserate(float pulserate) {
		this.pulserate = pulserate;
	}
	public float getBpSystolic() {
		return bpSystolic;
	}
	public void setBpSystolic(float bpSystolic) {
		this.bpSystolic = bpSystolic;
	}
	public float getBpDistolic() {
		return bpDistolic;
	}
	public void setBpDistolic(float bpDistolic) {
		this.bpDistolic = bpDistolic;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getBmi() {
		return bmi;
	}
	public void setBmi(float bmi) {
		this.bmi = bmi;
	}
}