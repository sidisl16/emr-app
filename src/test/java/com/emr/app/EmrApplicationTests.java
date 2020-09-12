package com.emr.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emr.app.mongo.dal.InventoryMongoDAL;
import com.emr.app.mongo.entities.MedicineInventory;

@SpringBootTest
class EmrApplicationTests {

	@Autowired
	private InventoryMongoDAL inventoryMongoDAL;

	@Test
	public void testGetMeicine() {
		MedicineInventory in = new MedicineInventory();
		in.setCompany("Colpol");
		in.setDose(650f);
		in.setName("Paracteamol");
		in.setRoute("Oral");
		MedicineInventory response = inventoryMongoDAL.findMedicineInventory(in);
		System.out.println(response);
	}

	@Test
	public void testSearchMedicine() {
		System.out.println(inventoryMongoDAL.searchmedicine("para", null));
	}

}
