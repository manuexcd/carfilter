package com.spring.carFilter.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.spring.carFilter.model.CarFilter;

public interface CarFilterRepository extends ReactiveCrudRepository<CarFilter, ObjectId> {

}