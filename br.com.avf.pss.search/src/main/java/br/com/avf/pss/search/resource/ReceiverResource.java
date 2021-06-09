package br.com.avf.pss.search.resource;

import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.avf.pss.search.service.SearchService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReceiverResource {

	private final SearchService service;

	@Autowired
	public ReceiverResource(SearchService service) {
		this.service = service;
	}
	
	@Bean
	public Queue queue() {
		return new Queue("SearchQ", false);
	}
	
	@RabbitListener(queues = "SearchQ")
	public void processMessage(Map<String, Object> fare) {
		this.service.update(fare);
	}
	
}
