package com.emr.app.mongo.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.emr.app.mongo.entities.MedicineInventory;

@Service
public class InventoryMongoDALImpl implements InventoryMongoDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public MedicineInventory upsertData(MedicineInventory medicinceInventory) {
		Criteria criteria = Criteria.where("name").regex("^" + medicinceInventory.getName() + "$", "i").and("company")
				.regex("^" + medicinceInventory.getCompany() + "$", "i").and("route")
				.regex("^" + medicinceInventory.getRoute() + "$", "i").and("dose").is(medicinceInventory.getDose());
		Query query = new Query(criteria);
		Update update = new Update().set("name", medicinceInventory.getName()).set("dose", medicinceInventory.getDose())
				.set("route", medicinceInventory.getRoute()).set("company", medicinceInventory.getCompany())
				.set("availableQuantity", medicinceInventory.getAvailableQuantity());
		mongoTemplate.upsert(query, update, MedicineInventory.class);
		return mongoTemplate.findOne(query, MedicineInventory.class);
	}

	@Override
	public MedicineInventory findMedicineInventory(MedicineInventory medicinceInventory) {
		Criteria criteria = Criteria.where("name").regex("^" + medicinceInventory.getName() + "$", "i").and("company")
				.regex("^" + medicinceInventory.getCompany() + "$", "i").and("route")
				.regex("^" + medicinceInventory.getRoute() + "$", "i").and("dose").is(medicinceInventory.getDose());
		return mongoTemplate.findOne(new Query(criteria), MedicineInventory.class);
	}

}
