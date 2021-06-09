package br.com.avf.pss.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.avf.pss.book.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
