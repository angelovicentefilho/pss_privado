package br.com.avf.pss.book.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Booking implements Serializable {

	public Booking(String flightNumber, String from, String to, String flightDate, Date bookingDate, String fare) {
		this.flightNumber = flightNumber;
		this.origin = from;
		this.destination = to;
		this.flightDate = flightDate;
		this.bookingDate = bookingDate;
		this.fare = fare;
	}

	private static final long serialVersionUID = 7108068199335063663L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Long id;
	private String flightNumber;
	private String origin;
	private String destination;
	private String flightDate;
	private Date bookingDate;
	private String fare;
	private String status;

	@OneToMany(fetch = EAGER, cascade = ALL, mappedBy = "booking")
	private Set<Passenger> passengers;

}
