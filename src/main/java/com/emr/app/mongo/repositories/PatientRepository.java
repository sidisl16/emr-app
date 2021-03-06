package com.emr.app.mongo.repositories;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.emr.app.mongo.entities.Patient;

public interface PatientRepository extends MongoRepository<Patient, ObjectId> {
	Optional<Patient> findByPatientId(String patientId);

	List<Patient> findByNameOrContactNoOrderByName(String name, String contactNo);

	@Query(value = "{}", sort = "{'name': 1}")
	List<Patient> findAllOrderByName();
}
