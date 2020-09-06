package com.emr.app.mongo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.emr.app.mongo.entities.MedicineInventory;

public interface MedicineInventoryRepository extends MongoRepository<MedicineInventory, ObjectId>{
}
