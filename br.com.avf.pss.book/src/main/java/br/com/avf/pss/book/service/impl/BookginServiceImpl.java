package br.com.avf.pss.book.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.aspectj.weaver.patterns.IVerificationRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.avf.pss.book.entity.Booking;
import br.com.avf.pss.book.entity.Inventory;
import br.com.avf.pss.book.entity.Passenger;
import br.com.avf.pss.book.repository.BookingRepository;
import br.com.avf.pss.book.repository.InventoryRepository;
import br.com.avf.pss.book.service.BookingService;
import br.com.avf.pss.book.service.BookingStatus;
import br.com.avf.pss.book.service.InventoryService;
import br.com.avf.pss.book.service.exception.BookingException;
import br.com.avf.pss.book.service.protocol.Fare;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookginServiceImpl implements BookingService {

	private static final String FARE_URL = "http://localhost:8082/fares/";

	private final BookingRepository bookingRepository;
	private final InventoryService inventoryService;
	private final RestTemplate restTemplate;
	private final SenderService sender;

	@Autowired
	public BookginServiceImpl(final BookingRepository bookingRepository, final RestTemplate restTemplate,
			final SenderService sender, final InventoryService inventoryService) {
		this.bookingRepository = bookingRepository;
		this.inventoryService = inventoryService;
		this.restTemplate = restTemplate;
		this.sender = sender;
	}

	@Override
	public Long create(Booking booking) {
		log.info(">>> Calling fares to get fare");
		Fare fare = restTemplate.getForObject(
				FARE_URL + booking.getFlightNumber() + "/" + booking.getFlightDate(),
				Fare.class);
		log.info("<<< flare '{}'", fare);
		Inventory inventory = inventoryService.findByFlightNumberAndFlightDate(booking.getFlightNumber(), booking.getFlightDate(), booking.getPassengers().size());
		log.info(">>> Saving booking");
		booking.setStatus(BookingStatus.BOOKING_CONFIRMED);
		Set<Passenger> passengers = booking.getPassengers();
		passengers.forEach(passenger -> passenger.setBooking(booking));
		booking.setBookingDate(Calendar.getInstance().getTime());
		Long id = bookingRepository.save(booking).getId();
		log.info("<<< successfully save booking");
		sendMessage(booking, inventory);
		return id;
	}

	private void sendMessage(Booking booking, Inventory inventory) {
		Map<String, Object> details = new HashMap<>();
		details.put("FLIGHT_NUMBER", booking.getFlightNumber());
		details.put("FLIGHT_DATE", booking.getFlightDate());
		details.put("NEW_INVENTORY", inventory.getBookableInventory());
		log.info(">>> Send book event");
		sender.send(details);
		log.info("<<< booking successfully delivery '{}'", details);
	}

	@Override
	public Booking get(Long id) {
		return this.bookingRepository.getOne(id);
	}

	@Override
	public void update(String checkedIn, Long bookingId) {
		Booking inner = this.bookingRepository.getOne(bookingId);
		inner.setStatus(checkedIn);
	}

}
