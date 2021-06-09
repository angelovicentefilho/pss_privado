package br.com.avf.pss.search.resource;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avf.pss.search.entity.Flight;
import br.com.avf.pss.search.service.SearchService;
import br.com.avf.pss.search.service.protocol.SearchRequest;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchResource {

	private final SearchService searchService;

	public SearchResource(final SearchService searchService) {
		this.searchService = searchService;
	}
	
	@PostMapping
	List<Flight> search(@RequestBody SearchRequest request) {
		return this.searchService.search(request);
	}

}
