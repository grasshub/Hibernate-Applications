package trivera.hibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

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
public class MovieTheater implements Serializable {

	private static final long serialVersionUID = 9152462740394144001L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cinemaId;
	
	@NotEmpty
	@Column(length = 128)
	private String name;
	
	@NotEmpty
	@Column(length = 128)
	private String address;
	
	@NotEmpty
	@Column(length = 40)
	private String city;
	
	@NotEmpty
	@Column(length = 5)
	private String postalCode;
	
	@NotEmpty
	@Column(length = 20)
	private String state;
	
	@NotEmpty
	@Column(length = 12)
	@ElementCollection
	private List<String> phoneNumbers = new ArrayList<>();
	
	public MovieTheater() {}

	public Integer getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Integer cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "MovieTheater [cinemaId=" + cinemaId + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", postalCode=" + postalCode + ", state=" + state + ", phoneNumbers=" + Arrays.toString(phoneNumbers.toArray()) + "]";
	}

}
