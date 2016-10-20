package com.xvitcoder.springmvcangularjs.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xvitcoder.springmvcangularjs.beans.Train;
import com.xvitcoder.springmvcangularjs.repositories.TrainRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TrainMongoServiceTest {

	@Autowired
	private TrainService mongoService;
	@Autowired
	private TrainRepository trainRepository;
	

	@Before
	public void setUp() throws Exception {
		Train train = new Train("111", "TestTrain", 200, true);
		List<Train> asList = new ArrayList<Train>();
		asList.add(train);
		Mockito.when(trainRepository.findAll()).thenReturn(asList);
	}

	@Test
	public void testGetAllTrains() {
		List<Train> allTrains = mongoService.getAllTrains();
		System.out.println(allTrains);
		assertEquals(1, allTrains.size());
	}

	@Configuration
	static class AccountServiceTestContextConfiguration {
		@Bean
		public TrainMongoService trainService() {
			return new TrainMongoService();
		}
		@Bean
		public TrainRepository trainRepository() {
			return Mockito.mock(TrainRepository.class);
		}
	}

}
