package com.emr.app.mongo.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.emr.app.mongo.entities.Case;

public interface CaseRepository extends MongoRepository<Case, ObjectId> {
	List<Case> findByPatientOrderByCreatedAtDesc(String patientId);
}
