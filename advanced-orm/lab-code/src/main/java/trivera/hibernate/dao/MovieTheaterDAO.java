package trivera.hibernate.dao;

import trivera.hibernate.model.MovieTheater;

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
public interface MovieTheaterDAO {

	public Integer save(MovieTheater movieTheater);

	public MovieTheater getTheaterById(Integer id);
}
