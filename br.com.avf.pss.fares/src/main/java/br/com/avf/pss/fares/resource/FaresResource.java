package br.com.avf.pss.fares.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.avf.pss.fares.entity.Fare;
import br.com.avf.pss.fares.service.FaresService;

@RestController
@CrossOrigin
@RequestMapping("/fares")
public class FaresResource {

	private final FaresService faresService;

	@Autowired
	public FaresResource(final FaresService faresService) {
		this.faresService = faresService;
	}

	@GetMapping("/{flightNumber}/{flightDate}")
	public Fare findFare(@PathVariable("flightNumber") String flightNumber,
			@PathVariable("flightDate") String flightDate) {
		return faresService.findFare(flightNumber, flightDate);
	}

}
