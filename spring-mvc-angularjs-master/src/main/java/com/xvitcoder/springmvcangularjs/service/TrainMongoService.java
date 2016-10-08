package com.xvitcoder.springmvcangularjs.service;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.stereotype.Component;

import com.xvitcoder.springmvcangularjs.beans.Train;
import com.xvitcoder.springmvcangularjs.dao.TrainDAO;

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
		Datastore ds = dao.getDatastore();
		Query<Train> query = ds.createQuery(Train.class).field("id").equal(train.getId());
		UpdateOperations<Train> ops = ds.createUpdateOperations(Train.class).set("name", train.getName()).set("speed", train.getSpeed()).set("diesel", train.getDiesel());

		ds.update(query, ops);
	}
	

}
