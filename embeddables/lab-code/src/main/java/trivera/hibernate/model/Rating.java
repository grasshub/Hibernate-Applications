package trivera.hibernate.model;

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
public enum Rating {

	NR("Not Rated", "Not Rated"),

	G("General Audiences", "All Ages Admitted"),

	PG("Parental Guidance Suggested", "Some Material May Not Be Suitable For Children"),

	PG13("Parents Strongly Cautioned", "Some Material May Be Inappropriate For Children Under 13"),

	R("Restricted", "Under 17 Requires Accompanying Parent Or Adult Guardian"),

	NC17("Adults Only", "No One 17 and Under Admitted");

	private String title;
	private String description;

	private Rating(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
}
