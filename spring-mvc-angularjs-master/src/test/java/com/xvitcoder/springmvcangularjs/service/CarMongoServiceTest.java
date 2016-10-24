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

import com.xvitcoder.springmvcangularjs.beans.Car;
import com.xvitcoder.springmvcangularjs.beans.Train;
import com.xvitcoder.springmvcangularjs.repositories.CarRepository;
import com.xvitcoder.springmvcangularjs.repositories.TrainRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CarMongoServiceTest {

	@Autowired
	private CarService service;
	@Autowired
	private CarRepository repository;
	
	@Before
	public void setUp() throws Exception {
		Car car = new Car("idForTest", "TestCarName");
		List<Car> asList = new ArrayList<Car>();
		asList.add(car);
		Mockito.when(repository.findAll()).thenReturn(asList);
	}

	@Test
	public void testGetAllCars() {
		List<Car> allCars = service.getAllCars();
		System.out.println(allCars);
		assertEquals(1, allCars.size());
	}

	
	@Configuration
	static class CarServiceTestContextConfiguration {
		@Bean
		public CarMongoService trainService() {
			return new CarMongoService();
		}
		@Bean
		public CarRepository trainRepository() {
			return Mockito.mock(CarRepository.class);
		}
	}

}
