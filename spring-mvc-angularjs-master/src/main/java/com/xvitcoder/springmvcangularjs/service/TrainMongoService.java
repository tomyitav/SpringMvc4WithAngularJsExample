package com.xvitcoder.springmvcangularjs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xvitcoder.springmvcangularjs.beans.Train;
import com.xvitcoder.springmvcangularjs.repositories.TrainRepository;

@Service("trainMongoService")
public class TrainMongoService implements TrainService{

	@Autowired
	private TrainRepository repository;

	@Override
	public List<Train> getAllTrains() {
		return repository.findAll();
	}

	@Override
	public Train getTrainById(String id) {
		return repository.findTrainById(id);
	}

	@Override
	public void addTrain(Train train) {
		repository.save(train);
	}

	@Override
	public void deleteTrainById(String id) {
		repository.deleteTrainById(id);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public void updateTrain(Train train) {
		repository.save(train);
	}
	
}
