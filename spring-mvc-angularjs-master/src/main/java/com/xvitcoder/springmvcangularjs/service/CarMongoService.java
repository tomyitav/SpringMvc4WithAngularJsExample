package com.xvitcoder.springmvcangularjs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xvitcoder.springmvcangularjs.beans.Car;
import com.xvitcoder.springmvcangularjs.repositories.CarRepository;

@Service("carMongoService")
public class CarMongoService implements CarService{

	@Autowired
	private CarRepository repository;

	@Override
	public List<Car> getAllCars() {
		return repository.findAll();
	}

	@Override
	public void addCar(Car car) {
		repository.save(car);
	}

	@Override
	public void deleteCar(String name) {
		repository.deleteCarByName(name);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}
	

}
