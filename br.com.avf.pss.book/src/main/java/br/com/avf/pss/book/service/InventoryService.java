package br.com.avf.pss.book.service;

import br.com.avf.pss.book.entity.Inventory;

public interface InventoryService {

	Inventory findByFlightNumberAndFlightDate(String number, String date, int passengers);

}
