package com.emr.app.mongo.dal;

import java.util.List;

import com.emr.app.mongo.entities.MedicineInventory;

public interface InventoryMongoDAL {

	MedicineInventory upsertData(MedicineInventory medicinceInventory);

	MedicineInventory findMedicineInventory(MedicineInventory medicinceInventory);

	List<MedicineInventory> searchmedicine(String name, String company);
}
