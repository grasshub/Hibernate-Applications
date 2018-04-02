package trivera.hibernate.client;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import trivera.hibernate.configuration.PersistenceJavaConfig;
import trivera.hibernate.dao.MovieTheaterDAO;
import trivera.hibernate.dao.ScreenDAO;
import trivera.hibernate.model.MovieTheater;
import trivera.hibernate.model.Screen;
import trivera.hibernate.model.Screen.ScreenId;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, Inc., Worldwide
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Technologies, Inc.
 *
 * Copyright (c) 2016 Trivera Technologies, Inc. http://www.triveratech.com
 * </p>
 * 
 * @author The Trivera Tech Team.
 */
@ContextConfiguration(classes = PersistenceJavaConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestClient {
	
	private static final List<String> phoneNumbers = Arrays.asList("302-555-6666", "302-111-6666", "302-222-6666");
	
	@Autowired
	private MovieTheaterDAO movieTheaterDAO;
	
	@Autowired
	private ScreenDAO screenDAO;

	@Test
	public void testMovieTheatherDAOImpl() {
		MovieTheater theater = new MovieTheater();
		theater.setName("Magic Lantern");
		theater.setAddress("9 Depot Street");
		theater.setCity("Bridgton");
		theater.setPostalCode("04009");
		theater.setPhoneNumbers(phoneNumbers);
		theater.setState("DE");
		
		System.out.println("Saving Movie Theater data in database");
	
		Integer movieTheatherID = movieTheaterDAO.save(theater);
		System.out.printf("Movie Theater was added to database with id %d\n", movieTheatherID);
		System.out.println("-----------------------------");
		System.out.printf("Retrieving Movie Theater with id %d\n", movieTheatherID);

		MovieTheater movieTheaterById = movieTheaterDAO.getTheaterById(movieTheatherID);
		System.out.println("Movie Theater Found: " + movieTheaterById);
	}
	
	@Test
	public void testScreenDAOImpl() {
		Screen screen = new Screen();
		
		Screen.ScreenId screenId = new Screen.ScreenId();
		// Need to change either cinemaId or screenNumber to avoid duplecate key.
		screenId.setCinemaId(222222);
		screenId.setScreenNumber(2);
		
		screen.setId(screenId);
		screen.setSeats(355);
		
		System.out.println("Saving Theater Screen data in database");
		
		ScreenId movieScreenId = screenDAO.save(screen);
		System.out.printf("Theater Screen was added to database with id %s\n", movieScreenId);
		System.out.println("-----------------------------");
		System.out.printf("Retrieving Theater Screen with id %s\n", movieScreenId);
		
		Screen movieScreen = screenDAO.getScreenById(movieScreenId);
		System.out.println("Theater Screen Found: " + movieScreen);
	}
	
}
