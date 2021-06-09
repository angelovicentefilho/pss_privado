package br.com.avf.pss.search.service;

import java.util.List;
import java.util.Map;

import br.com.avf.pss.search.entity.Flight;
import br.com.avf.pss.search.service.protocol.SearchRequest;

public interface SearchService {

	void update(Map<String, Object> fare);

	List<Flight> search(SearchRequest request);

}
