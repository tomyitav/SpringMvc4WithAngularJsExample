package com.xvitcoder.springmvcangularjs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xvitcoder.springmvcangularjs.beans.RailwayStation;
import com.xvitcoder.springmvcangularjs.repositories.RailwayStationRepository;

@Service("railwayMongoService")
public class RailwayMongoService implements RailwayStationService {
	
	@Autowired
	private RailwayStationRepository repository;

	@Override
	public List<RailwayStation> getAllRailwayStations() {
		return repository.findAll();
	}

	@Override
	public RailwayStation getRailwayStationById(String id) {
		return repository.findRailwayStationById(id);
	}

	@Override
	public void addRailwayStation(RailwayStation railwayStation) {
		repository.save(railwayStation);
	}

	@Override
	public void deleteRailwayStationById(String id) {
		repository.deleteRailwayStationById(id);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public void updateRailwayStation(RailwayStation railwayStation) {
		// TODO Auto-generated method stub
		repository.save(railwayStation);
	}

}
