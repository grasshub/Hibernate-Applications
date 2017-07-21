package trivera.hibernate.model;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import trivera.hibernate.converter.DurationConverter;

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
@Entity
@Table(name = "MOVIES")
public class Movie implements Serializable {

	private static final long serialVersionUID = -5657845196591431561L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String title;
	private String studio;

	private Double price;
	private LocalDate releaseDate;

	@Convert(converter = DurationConverter.class)
	private Duration length;

	@Enumerated(EnumType.STRING)
	private Rating rating;
	
	public Movie() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Duration getLength() {
		return length;
	}

	public void setLength(Duration length) {
		this.length = length;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", studio=" + studio + ", price=" + price + ", releaseDate="
				+ releaseDate + ", Length=" + length.toMinutes() + ", Rating=" + rating + "]";
	}

}