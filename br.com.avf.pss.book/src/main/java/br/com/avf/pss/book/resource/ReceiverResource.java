package br.com.avf.pss.book.resource;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.avf.pss.book.service.BookingService;
import br.com.avf.pss.book.service.BookingStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReceiverResource {

	private final BookingService service;

	@Autowired
	public ReceiverResource(BookingService service) {
		this.service = service;
	}
	
	@RabbitListener(queues = "CheckInQ")
	public void processBookingStatus(Long bookingId) {
		log.info(">>> Update booking: '{}'", bookingId);
		this.service.update(BookingStatus.CHECKED_IN, bookingId);
	}
	
}
