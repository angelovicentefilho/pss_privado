package br.com.avf.pss.book.entity;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "passengers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Passenger implements Serializable {

	public Passenger(String firstName, String lastName, String gender, Booking booking) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.booking = booking;
	}

	private static final long serialVersionUID = 7299722626865496385L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passenger_id")
	private Long id;

	private String firstName;
	private String lastName;
	private String gender;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "booking_id")
	@JsonIgnore
	private Booking booking;

}
