package br.com.avf.pss.book.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avf.pss.book.entity.Booking;
import br.com.avf.pss.book.service.BookingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/bookings")
public class BookingResource {

	private final BookingService bookingService;

	@Autowired
	public BookingResource(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@PostMapping
	public Long create(@RequestBody Booking booking) {
		log.info(">>> Booking request: '{}'", booking);
		return this.bookingService.create(booking);
	}
	
	@GetMapping("/{id}")
	Booking get(@PathVariable Long id) {
		return this.bookingService.get(id);
	}
	
}
