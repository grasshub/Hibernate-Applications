package trivera.hibernate.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import trivera.hibernate.model.Screen;
import trivera.hibernate.model.Screen.ScreenId;

@Repository
@Transactional
public class ScreenDAOImpl implements ScreenDAO {
	
	private HibernateTemplate hibernateTemplate;
	
	public ScreenDAOImpl(HibernateTemplate  hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public ScreenId save(Screen screen) {
		ScreenId screenId = (ScreenId) hibernateTemplate.save(screen);
		return screenId;
	}

	@Override
	public Screen getScreenById(ScreenId id) {
		Screen screen = hibernateTemplate.get(Screen.class, id);
		return screen;
	}

}
