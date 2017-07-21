package trivera.hibernate.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
@Embeddable
public class Review implements Serializable {

	private static final long serialVersionUID = -3788849888845873432L;

	@NotEmpty
	@Column(length = 30)
	private String username;
	
	@NotNull
	private LocalDate entryDate;
	
	@NotEmpty
	@Column(length = 500)
	private String description;

	public Review() {}
	
	public Review(String username, LocalDate entryDate, String description) {
		this.username = username;
		this.entryDate = entryDate;
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Review [username=" + username + ", entryDate=" + entryDate + ", description=" + description + "]";
	}

}
