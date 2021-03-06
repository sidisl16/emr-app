package com.emr.app.service;

import java.util.Set;

import com.emr.app.dtos.MedicineInventoryDto;

public interface AutoSuggestionService {

	public void loadAllMedicineAndExaminationDataInMemory();

	public Set<MedicineInventoryDto> searchMedicineByPrefix(String prefix);

	public Set<String> searchExaminationByPrefix(String prefix);

	void addMedicineToTrie(MedicineInventoryDto medicineInventoryDto);

	void addExaminationToTrie(String examination);

	void updateMedicineTrie(MedicineInventoryDto medicineInventoryDto);

	void removeMedicineFromMedicineTrie(MedicineInventoryDto medicineInventoryDto);

	void removeExaminationFromTrie(String examination);
}
