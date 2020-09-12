package com.emr.app.mongo.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.emr.app.mongo.entities.MedicineInventory;

public interface MedicineInventoryRepository extends MongoRepository<MedicineInventory, ObjectId> {
	@Query(value = "{}", sort = "{'name': -1, 'company':-1}")
	List<MedicineInventory> findAllOrderByName();
}
	