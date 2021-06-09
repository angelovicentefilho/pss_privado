package br.com.avf.pss.fares.service;

import br.com.avf.pss.fares.entity.Fare;

public interface FaresService {

	Fare findFare(String flightNumber, String flightDate);

}
