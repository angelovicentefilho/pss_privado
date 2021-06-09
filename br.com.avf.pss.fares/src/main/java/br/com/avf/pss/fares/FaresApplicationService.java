package br.com.avf.pss.fares;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.avf.pss.fares.entity.Fare;
import br.com.avf.pss.fares.repository.FaresRepository;

@SpringBootApplication
public class FaresApplicationService implements CommandLineRunner {

	@Autowired
	private FaresRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(FaresApplicationService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Fare[] fares = { //
				new Fare("BF100", "22-JAN-22", "100"), //
				new Fare("BF101", "22-JAN-22", "101"), //
				new Fare("BF102", "22-JAN-22", "102"), //
				new Fare("BF103", "22-JAN-22", "103"), //
				new Fare("BF104", "22-JAN-22", "104"), //
				new Fare("BF105", "22-JAN-22", "105"), //
				new Fare("BF106", "22-JAN-22", "106"), //
				new Fare("BF107", "22-JAN-22", "107"), //
				new Fare("BF108", "22-JAN-22", "108"), //
		};
		Arrays.stream(fares).collect(Collectors.toList()).forEach(fare -> this.repository.save(fare));
	}

}
