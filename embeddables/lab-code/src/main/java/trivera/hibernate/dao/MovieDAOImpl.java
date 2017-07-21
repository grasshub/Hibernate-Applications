package trivera.hibernate.dao;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import trivera.hibernate.model.Movie;

@Repository
@Transactional
public class MovieDAOImpl implements MovieDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	public MovieDAOImpl(HibernateTemplate  hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public Integer addMovie(Movie movie) {
		Integer id = (Integer) hibernateTemplate.save(movie);
		
		return id;
	}
	
	// In order to initialize list of lazily loaded reviews and showTimes fields before transaction is committed and session is closed,
	// we need to utilize Hibernate class initialize method to fetch these two lists before transaction is committed.
	// This strategy will resolve standalone application issue with accessing lazily loaded list field after session is closed and could
	// not retrieve the list through the closed session.
	@Override
	public Movie getMovieById(Integer id) {
		
		Movie movie = hibernateTemplate.get(Movie.class, id);
		
		// Initialize lazily loaded showTimes and reviews list before the transaction is committed and session is closed automatically.
		Hibernate.initialize(movie.getShowtimes());
		Hibernate.initialize(movie.getReviews());
		
		return movie;
	}

}
