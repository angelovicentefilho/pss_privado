package br.com.avf.pss.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.avf.pss.search.entity.Fares;
import br.com.avf.pss.search.entity.Flight;
import br.com.avf.pss.search.entity.Inventory;
import br.com.avf.pss.search.repository.FlightRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SearchApplicationService implements CommandLineRunner {

	@Autowired
	private FlightRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SearchApplicationService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Flight> flights = new ArrayList<>();
		flights.add(new Flight("BF100", "SEA", "SFO", "22-JAN-22", new Fares("100", "USD"), new Inventory(100)));
		flights.add(new Flight("BF101", "NYC", "SFO", "22-JAN-22", new Fares("101", "USD"), new Inventory(100)));
		flights.add(new Flight("BF105", "NYC", "SFO", "22-JAN-22", new Fares("105", "USD"), new Inventory(100)));
		flights.add(new Flight("BF106", "NYC", "SFO", "22-JAN-22", new Fares("106", "USD"), new Inventory(100)));
		flights.add(new Flight("BF102", "CHI", "SFO", "22-JAN-22", new Fares("102", "USD"), new Inventory(100)));
		flights.add(new Flight("BF103", "HOU", "SFO", "22-JAN-22", new Fares("103", "USD"), new Inventory(100)));
		flights.add(new Flight("BF104", "LAX", "SFO", "22-JAN-22", new Fares("104", "USD"), new Inventory(100)));
		repository.saveAll(flights);
		log.info("Looking to load flights...");
		for (Flight flight : repository.findByOriginAndDestinationAndFlightDate("NYC", "SFO", "22-JAN-22")) {
			log.info(flight.toString());
		}
	}

}
