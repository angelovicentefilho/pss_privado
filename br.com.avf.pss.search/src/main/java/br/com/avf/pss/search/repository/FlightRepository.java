package br.com.avf.pss.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avf.pss.search.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

	List<Flight> findByOriginAndDestinationAndFlightDate(String origin, String destination, String flightDate);
	
	Flight findByFlightNumberAndFlightDate(String flightNumber, String flightDate);
	
}
