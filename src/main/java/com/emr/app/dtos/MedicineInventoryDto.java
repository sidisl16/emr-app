package com.emr.app.dtos;

public class MedicineInventoryDto {

	private String medicineInventoryId;
	private String name;
	private Float dose;
	private String route;
	private String company;
	private Integer availableQuantity;

	public MedicineInventoryDto() {
	}

	public MedicineInventoryDto( String name, Float dose, String route, String company,
			Integer availableQuantity) {
		this.name = name;
		this.dose = dose;
		this.route = route;
		this.company = company;
		this.availableQuantity = availableQuantity;
	}

	public String getMedicineInventoryId() {
		return medicineInventoryId;
	}

	public void setMedicineInventoryId(String medicineInventoryId) {
		this.medicineInventoryId = medicineInventoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getDose() {
		return dose;
	}

	public void setDose(Float dose) {
		this.dose = dose;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.toLowerCase().hashCode());
		result = prime * result + ((dose == null) ? 0 : dose.hashCode());
		result = prime * result + ((name == null) ? 0 : name.toLowerCase().hashCode());
		result = prime * result + ((route == null) ? 0 : route.toLowerCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicineInventoryDto other = (MedicineInventoryDto) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equalsIgnoreCase(other.company))
			return false;
		if (dose == null) {
			if (other.dose != null)
				return false;
		} else if (!dose.equals(other.dose))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equalsIgnoreCase(other.name))
			return false;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equalsIgnoreCase(other.route))
			return false;
		return true;
	}

// Do modify this code
	@Override
	public String toString() {
		return company + " " + name + " " + dose + "mg ";
	}
}