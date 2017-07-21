package trivera.hibernate.model;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
@Table(name = "T001_MOVIES")
public class Movie implements Serializable {

	private static final long serialVersionUID = -1012278394088065868L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(length = 50)
	private String title;
	
	@NotEmpty
	@Column(length = 50)
	private String studio;

	@NotNull
	private Double price;
	
	@NotNull
	private LocalDate releaseDate;

	@NotNull
	@Convert(converter = DurationConverter.class)
	private Duration length;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Rating rating;

	@NotNull
	@ElementCollection
	@CollectionTable(name = "SHOWTIMES")
	private List<LocalTime> showtimes = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "REVIEWS")
	@AttributeOverrides({@AttributeOverride(name = "entryDate", column = @Column(name = "REVIEW_DATE")), 
		@AttributeOverride(name = "description", column = @Column(name = "REVIEW"))})
	@OrderBy("REVIEW_DATE")
	private List<Review> reviews = new ArrayList<>();
	
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

	public List<LocalTime> getShowtimes() {
		return showtimes;
	}

	public void addShowtime(LocalTime showtime) {
		this.showtimes.add(showtime);
	}

	public void setShowtimes(List<LocalTime> showtimes) {
		this.showtimes = showtimes;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", studio=" + studio + ", price=" + price + ", releaseDate="
				+ releaseDate + ", length=" + length.toMinutes() + ", rating=" + rating + ", showtimes=" + showtimes + ", reviews="
				+ reviews + "]";
	}

}