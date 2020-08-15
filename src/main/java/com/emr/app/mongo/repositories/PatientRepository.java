package com.emr.app.mongo.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.emr.app.mongo.entities.Patient;

public interface PatientRepository extends MongoRepository<Patient, ObjectId> {
	Optional<Patient> findByPatientId(String patientId);
}
