package br.com.avf.pss.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avf.pss.book.entity.Inventory;
import br.com.avf.pss.book.repository.InventoryRepository;
import br.com.avf.pss.book.service.InventoryService;
import br.com.avf.pss.book.service.exception.BookingException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InventoryServiceImpl implements InventoryService {

	private final InventoryRepository repository;
	
	@Autowired
	public InventoryServiceImpl(final InventoryRepository repository) {
		this.repository = repository;
	}
	
	public Inventory findByFlightNumberAndFlightDate(String number, String date, int passengers) {
		log.info(">>> Checking inventory");
		Inventory inventory = repository.findByFlightNumberAndFlightDate(number, date);
		if (!inventory.isAvaliable(passengers)) {
			throw new BookingException("No more seats avaiable!");
		}
		log.info("<<< successfully checked inventory!");
		log.info(">>> calling inventory to update inventory");
		inventory.setAvaliable(inventory.getAvaliable() - passengers);
		repository.saveAndFlush(inventory);
		log.info("<<< successfully updated inventory");
		return inventory;
	}
	
}
