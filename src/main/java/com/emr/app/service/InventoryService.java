package com.emr.app.service;

import java.io.File;
import java.util.List;

import com.emr.app.dtos.MedicineInventoryDto;

public interface InventoryService {

	MedicineInventoryDto addMedicine(MedicineInventoryDto medicineInventoryDto) throws Exception;

	MedicineInventoryDto updateMedicine(MedicineInventoryDto medicineInventoryDto) throws Exception;

	void uploadInventoryFile(File inventoryFile) throws Exception;

	List<MedicineInventoryDto> getAllMedicine();

	List<MedicineInventoryDto> searchMedicine(String name, String company);

	void deleteMedicineById(String id);
}
