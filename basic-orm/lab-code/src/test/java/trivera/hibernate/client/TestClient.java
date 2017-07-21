package trivera.hibernate.client;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import trivera.hibernate.configuration.PersistenceJavaConfig;
import trivera.hibernate.dao.MovieDAO;
import trivera.hibernate.model.Movie;
import trivera.hibernate.model.Rating;

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
	
	@Autowired
	private MovieDAO movieDAO;

	@Test
	public void testMovieDAOImpl() {
		Movie movie = new Movie();

		movie.setTitle("Frozen");
		movie.setReleaseDate(LocalDate.of(2013, Month.DECEMBER, 11));
		movie.setStudio("Walt Disney Animation Studios");
		movie.setPrice(16.95);
		movie.setRating(Rating.G);
		movie.setLength(Duration.ofMinutes(109));

		System.out.println("Saving Movie data in database");
	
		Integer movieID = movieDAO.addMovie(movie);
		System.out.printf("Movie was added to database with id %d\n", movieID);
		System.out.println("-----------------------------");
		System.out.printf("Retrieving Movie with id %d\n", movieID);

		Movie movieById = movieDAO.getMovieById(movieID);
		System.out.println("Movie Found: " + movieById);
	}
	
}
