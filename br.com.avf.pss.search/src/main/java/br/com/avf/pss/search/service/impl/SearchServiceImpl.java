package br.com.avf.pss.search.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avf.pss.search.entity.Flight;
import br.com.avf.pss.search.entity.Inventory;
import br.com.avf.pss.search.repository.FlightRepository;
import br.com.avf.pss.search.service.SearchService;
import br.com.avf.pss.search.service.protocol.SearchRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SearchServiceImpl implements SearchService {
	
	private final FlightRepository repository;

	@Autowired
	public SearchServiceImpl(FlightRepository repository) {
		this.repository = repository;
	}
	
	
	
	@Override
	public void update(Map<String, Object> fare) {
		log.info(">>> Update inventory: '{}'", fare);
		String flightNumber = (String) fare.get("FLIGHT_NUMBER");
		String flightDate = (String) fare.get("FLIGHT_DATE");
		Integer inventory = (Integer) fare.get("NEW_INVENTORY");
		Flight flight = this.repository.findByFlightNumberAndFlightDate(flightNumber, flightDate);
		Inventory inv = flight.getInventory();
		inv.setCount(inventory);
		this.repository.save(flight);
		log.info("<<< Inventory updated!");
	}



	@Override
	public List<Flight> search(SearchRequest request) {
		List<Flight> flights = this.repository.findByOriginAndDestinationAndFlightDate(request.getOrigin(), request.getDestination(), request.getFlightDate());
		List<Flight> results = new ArrayList<>();
		results.addAll(flights);
		flights.forEach(flight -> {
			flight.getFares();
			int inv = flight.getInventory().getCount();
			if (inv < 0) {
				results.remove(flight);
			}
		});
		return results;
	}

}
