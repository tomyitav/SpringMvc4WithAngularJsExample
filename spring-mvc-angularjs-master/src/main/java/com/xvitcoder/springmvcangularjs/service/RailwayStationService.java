package com.xvitcoder.springmvcangularjs.service;

import com.xvitcoder.springmvcangularjs.beans.RailwayStation;

import java.util.List;


public interface RailwayStationService {
	
    public List<RailwayStation> getAllRailwayStations();

    public RailwayStation getRailwayStationById(String id);

    public void addRailwayStation(RailwayStation RailwayStation);

    public void deleteRailwayStationById(String id);

    public void deleteAll();

    public void updateRailwayStation(RailwayStation RailwayStation);
}
