package trivera.hibernate.dao;

import javax.transaction.Transactional;

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

	@Override
	public Movie getMovieById(Integer id) {
		Movie movie = hibernateTemplate.get(Movie.class, id);
		
		return movie;
	}

}
