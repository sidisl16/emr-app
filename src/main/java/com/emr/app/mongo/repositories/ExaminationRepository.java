package com.emr.app.mongo.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.emr.app.mongo.entities.Examination;

public interface ExaminationRepository extends MongoRepository<Examination, ObjectId> {
	@Query(value = "{}", sort = "{'name': -1}")
	List<Examination> findAllOrderByName();
}
