package com.xvitcoder.springmvcangularjs.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.xvitcoder.springmvcangularjs.beans.Car;

@Repository
public interface CarRepository extends MongoRepository<Car,String>{
	Long deleteCarByName(String name);
}
