package com.emr.app.mongo.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.emr.app.mongo.entities.Case;

public interface CaseRepository extends MongoRepository<Case, ObjectId> {
	@Query(value = "{ 'patient.$id' : ?0 }", sort = "{'createdAt': -1}")
	List<Case> findByPatientId(ObjectId id);
}
