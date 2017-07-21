package trivera.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MOVIE_SCREEN")
public class Screen implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ScreenId id;
	
	@NotNull
	@Column(length = 3)
	private Integer seats;
	
	public Screen() {}
	
	public ScreenId getId() {
		return id;
	}

	public void setId(ScreenId id) {
		this.id = id;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	
	@Override
	public String toString() {
		return "Screen [cinemaId=" + id.getCinemaId() + ", screenNumber=" + id.getScreenNumber() + ", seats=" + seats + "]";
	}
	
	@Embeddable
	public static class ScreenId implements Serializable {

		private static final long serialVersionUID = -2182282346458402047L;
		
		private Integer cinemaId;
		private Integer screenNumber;
		
		public Integer getCinemaId() {
			return cinemaId;
		}

		public void setCinemaId(Integer cinemaId) {
			this.cinemaId = cinemaId;
		}
		
		public Integer getScreenNumber() {
			return screenNumber;
		}

		public void setScreenNumber(Integer screenNumber) {
			this.screenNumber = screenNumber;
		}
		
		@Override
		public int hashCode() {
			
			final int prime = 31;
			int result = prime + cinemaId;
			return prime * result + screenNumber;
		}
		
		@Override
		public boolean equals(Object object) {
			
			if (this == object)
				return true;
			
			if (object == null || getClass() != object.getClass())
				return false;
			
			ScreenId other = (ScreenId) object;
			
			if (cinemaId != other.getCinemaId() || screenNumber != other.getScreenNumber())
				return false;
			
			return true;
		}	
		
		@Override
		public String toString() {
			return "ScreenId [cinemaId=" + cinemaId + ", screenNumber=" + screenNumber + "]";
		}
	}

}
