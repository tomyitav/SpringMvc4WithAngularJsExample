package com.xvitcoder.springmvcangularjs.beans;

public class RailwayStation {

	private String id;
	
	private String name;
	
	private Train train;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
