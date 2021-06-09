package br.com.avf.pss.fares.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "fares")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Fare {

	public Fare(String flightNumber, String flightDate, String fare) {
		this.fare = fare;
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fare_id")
	private Long id;
	
	private String flightNumber;
	private String flightDate;
	private String fare;

}
