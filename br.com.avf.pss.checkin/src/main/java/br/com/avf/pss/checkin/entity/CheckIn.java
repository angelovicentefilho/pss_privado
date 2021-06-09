package br.com.avf.pss.checkin.entity;

import java.util.Date;

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
@Table(name = "checkins")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CheckIn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "checkin_id")
	private Long id;
	
	private String firstName;
	private String lastName;
	private Date checkInTime;
	private String flightNumber;
	private String fligthDate;
	private Long bookingId;
	
}
