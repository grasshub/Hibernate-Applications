package trivera.hibernate.dao;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import trivera.hibernate.model.MovieTheater;

@Repository
@Transactional
public class MovieTheaterDAOImpl implements MovieTheaterDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	public MovieTheaterDAOImpl(HibernateTemplate  hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public Integer save(MovieTheater movieTheater) {
		Integer id = (Integer) hibernateTemplate.save(movieTheater);
		
		return id;
	}

	// In order to initialize list of lazily loaded phoneNumbers field before transaction is committed and session is closed,
	// we need to utilize Hibernate class initialize method to load this list before transaction is committed.
	// This strategy will resolve standalone application issue with accessing lazily loaded list field after session is closed and could
	// not retrieve the list through the closed session.
	@Override
	public MovieTheater getTheaterById(Integer id) {
		MovieTheater movieTheater = hibernateTemplate.get(MovieTheater.class, id);
		
		// Initialize lazily loaded phoneNumbers list before the transaction is committed and session is closed automatically.
		Hibernate.initialize(movieTheater.getPhoneNumbers());
		
		return movieTheater;
	}

}
