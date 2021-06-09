package br.com.avf.pss.search.entity;

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
@Table(name = "flight_fares")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Fares {

    
	public Fares(String fare,String currency) {
		this.fare = fare;
		this.currency = currency;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fares_id")
	private Long id;
	private String fare;
	private String currency;

}
