package com.emr.app.dtos;

public class ExaminationDto {

	private String examinationId;
	private String name;
	private String description;

	public ExaminationDto() {
	}

	public ExaminationDto(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(String examinationId) {
		this.examinationId = examinationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}