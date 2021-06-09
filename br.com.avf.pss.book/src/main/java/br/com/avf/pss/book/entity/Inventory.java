package br.com.avf.pss.book.entity;

import java.io.Serializable;

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
@Table(name = "inventories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inventory implements Serializable {

	private static final long serialVersionUID = 5025130754183629514L;

	public Inventory(String flightNumber, String flightDate, int avaliable) {
		this.flightDate = flightDate;
		this.flightNumber = flightNumber;
		this.avaliable = avaliable;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private Long id;

	private String flightNumber;
	private String flightDate;
	private int avaliable;

	public boolean isAvaliable(int count) {
		return ((avaliable - count) > 5);
	}

	public int getBookableInventory() {
		return avaliable - 5;
	}

}
