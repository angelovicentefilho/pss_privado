package br.com.avf.pss.fares.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avf.pss.fares.entity.Fare;
import br.com.avf.pss.fares.repository.FaresRepository;
import br.com.avf.pss.fares.service.FaresService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FaresServiceImpl implements FaresService {

	private final FaresRepository repository;
	
	@Autowired
	public FaresServiceImpl(final FaresRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Fare findFare(String flightNumber, String flightDate) {
		log.info(">>> Find fares by flightNumber: '{}' and flightDate: '{}'", flightNumber, flightDate);
		return this.repository.findFareByFlightNumberAndFlightDate(flightNumber, flightDate);
	}

}
