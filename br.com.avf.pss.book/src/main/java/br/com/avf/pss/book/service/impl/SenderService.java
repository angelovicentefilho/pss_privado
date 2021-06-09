package br.com.avf.pss.book.service.impl;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SenderService {

	private final RabbitMessagingTemplate template;

	@Autowired
	public SenderService(RabbitMessagingTemplate template) {
		this.template = template;
	}

	@Bean
	public Queue queueSearch() {
		return new Queue("SearchQ", false);
	}

	@Bean
	public Queue queueCheckIn() {
		return new Queue("CheckInQ", false);
	}

	public void send(Object message) {
		template.convertAndSend("SearchQ", message);
	}

}
