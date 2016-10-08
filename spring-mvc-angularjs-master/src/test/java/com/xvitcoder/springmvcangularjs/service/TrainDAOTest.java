package com.xvitcoder.springmvcangularjs.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.xvitcoder.springmvcangularjs.beans.Train;
import com.xvitcoder.springmvcangularjs.dao.TrainDAO;

public class TrainDAOTest {

	@Test
	public void testSavingTrain() {
//		fail("Not yet implemented");
		Train train = new Train((long) 1, "firstTrain", 100, true);
		TrainDAO dao = new TrainDAO();
		dao.save(train);
	}

}
