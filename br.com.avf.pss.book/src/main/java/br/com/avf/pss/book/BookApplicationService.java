package br.com.avf.pss.book;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.avf.pss.book.entity.Booking;
import br.com.avf.pss.book.entity.Inventory;
import br.com.avf.pss.book.entity.Passenger;
import br.com.avf.pss.book.repository.InventoryRepository;
import br.com.avf.pss.book.service.BookingService;

@SpringBootApplication
public class BookApplicationService implements CommandLineRunner {

	@Autowired
	private InventoryRepository invRepository;
	@Autowired
	private BookingService bookingService;

	public static void main(String[] args) {
		SpringApplication.run(BookApplicationService.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Inventory[] invs = { //
				new Inventory("BF100", "22-JAN-22", 100), //
				new Inventory("BF101", "22-JAN-22", 100), //
				new Inventory("BF102", "22-JAN-22", 100), //
				new Inventory("BF103", "22-JAN-22", 100), //
				new Inventory("BF104", "22-JAN-22", 100), //
				new Inventory("BF105", "22-JAN-22", 100), //
				new Inventory("BF106", "22-JAN-22", 100) //
		};
		Arrays.asList(invs).forEach(inventory -> invRepository.save(inventory));
		Booking booking = new Booking("BF101", "NYC", "SFO", "22-JAN-22", new Date(), "101");
		Set<Passenger> passengers = new HashSet<Passenger>();
		passengers.add(new Passenger("Gean", "Franc", "Male", booking));
		booking.setPassengers(passengers);
		bookingService.create(booking);
	}

}
