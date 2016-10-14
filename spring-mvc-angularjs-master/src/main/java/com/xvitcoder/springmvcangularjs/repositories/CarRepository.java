package com.xvitcoder.springmvcangularjs.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xvitcoder.springmvcangularjs.beans.Car;

public interface CarRepository extends MongoRepository<Car,String>{
	Long deleteCarByName(String name);
}
