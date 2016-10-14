package com.xvitcoder.springmvcangularjs.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xvitcoder.springmvcangularjs.beans.RailwayStation;

public interface RailwayStationRepository extends MongoRepository<RailwayStation,String>{
	Long deleteRailwayStationById(String id);
	RailwayStation findRailwayStationById(String id);
}
