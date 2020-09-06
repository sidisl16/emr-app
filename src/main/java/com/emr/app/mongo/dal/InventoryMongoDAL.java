package com.emr.app.mongo.dal;

import com.emr.app.mongo.entities.MedicineInventory;

public interface InventoryMongoDAL {

	MedicineInventory upsertData(MedicineInventory medicinceInventory);

}
