package com.emr.app.mongo.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.emr.app.mongo.entities.Appointment;

public interface AppointmentRepository extends MongoRepository<Appointment, ObjectId> {

	List<Appointment> findByAcknowledgedOrderByDateAsc(boolean acknowledged);
}
