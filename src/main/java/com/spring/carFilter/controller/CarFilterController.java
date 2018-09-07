package com.spring.carFilter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.carFilter.model.CarFilter;
import com.spring.carFilter.repository.CarFilterRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CarFilterController {

	@Autowired
	private CarFilterRepository carFilterRepository;
	
	@GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<CarFilter> getAllCars() {
		return carFilterRepository.findAll();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Mono<CarFilter> filter(@RequestBody CarFilter car) {
		CarFilter newCar = new CarFilter();
		newCar.setBrand(car.getBrand());
		newCar.setModel(car.getModel());
		newCar.setColor("black");
		return carFilterRepository.save(newCar);
	}
}
