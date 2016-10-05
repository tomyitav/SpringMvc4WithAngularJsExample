package com.xvitcoder.springmvcangularjs.service;

import java.util.List;

import org.mongodb.morphia.query.QueryResults;
import org.springframework.stereotype.Component;

import com.xvitcoder.springmvcangularjs.beans.Train;

@Component("trainMongoService")
public class TrainMongoService implements TrainService{
	
	TrainDAO dao = new TrainDAO();
	private static Long id = 0L;

	@Override
	public List<Train> getAllTrains() {
		// TODO Auto-generated method stub
		QueryResults<Train> queryRes = dao.find();
		return queryRes.asList();
	}

	@Override
	public Train getTrainById(Long id) {
		// TODO Auto-generated method stub
		return dao.getDs().get(Train.class, id);
	}

	@Override
	public void addTrain(Train train) {
		train.setId(++id);
		dao.save(train);
	}

	@Override
	public void deleteTrainById(Long id) {
		dao.delete(getTrainById(id));
	}

	@Override
	public void deleteAll() {
//		dao.getDs().re
	}

	@Override
	public void updateTrain(Train train) {
		// TODO Auto-generated method stub
		
	}
	

}
