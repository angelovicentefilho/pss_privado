package br.com.avf.pss.fares.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avf.pss.fares.entity.Fare;

@Repository
public interface FaresRepository extends JpaRepository<Fare, Long> {

	Fare findFareByFlightNumberAndFlightDate(String number, String date);

}
