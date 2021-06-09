package br.com.avf.pss.book.service;

import br.com.avf.pss.book.entity.Booking;

public interface BookingService {

	Long create(Booking booking);

	Booking get(Long id);

	void update(String checkedIn, Long bookingId);
	
}
