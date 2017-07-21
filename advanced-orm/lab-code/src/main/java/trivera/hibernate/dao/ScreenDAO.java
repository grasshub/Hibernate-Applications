package trivera.hibernate.dao;

import trivera.hibernate.model.Screen;
import trivera.hibernate.model.Screen.ScreenId;

public interface ScreenDAO {
	
	public ScreenId save(Screen screen);

	public Screen getScreenById(ScreenId id);

}
