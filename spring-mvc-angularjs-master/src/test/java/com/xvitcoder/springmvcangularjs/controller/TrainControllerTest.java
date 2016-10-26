package com.xvitcoder.springmvcangularjs.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.xvitcoder.springmvcangularjs.beans.Train;
import com.xvitcoder.springmvcangularjs.service.TrainService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TrainControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private TrainController trainController;
	
	@Autowired 
	private TrainService trainServiceMock;
	
	@Before
	public void setUp() throws Exception {
		Train train1 = new Train("111", "TestTrain1", 200, true);
		Train train2 = new Train("222", "TestTrain2", 300, true);
		Mockito.when(trainServiceMock.getAllTrains()).thenReturn(Arrays.asList(train1, train2));
		Mockito.doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		}).when(trainServiceMock).deleteTrainById(Mockito.anyString());
//		setup mockMvc
		mockMvc = MockMvcBuilders.standaloneSetup(this.trainController).build();
	}

	@Test
	public void testGetTrainList() throws Exception {
		mockMvc.perform(get("/trains/trainslist.json")).andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].id", is("111")))
		.andExpect(jsonPath("$[0].name", is("TestTrain1")));
		
		Mockito.verify(trainServiceMock, Mockito.times(1)).getAllTrains();
		Mockito.verifyNoMoreInteractions(trainServiceMock);
	}
	
	@Test
	public void testRemoveTrainById() throws Exception {
		mockMvc.perform(delete("/trains/removeTrain/111")).andExpect(status().isOk());
		
		Mockito.verify(trainServiceMock, Mockito.times(1)).deleteTrainById("111");
		Mockito.verifyNoMoreInteractions(trainServiceMock);
	}

	
	@Configuration
	static class TrainControllerTestContextConfiguration {
		@Bean
		public TrainService trainService() {
			return Mockito.mock(TrainService.class);
		}
		
		@Bean
		public TrainController trainController() {
			return new TrainController();
		}
	}
}
