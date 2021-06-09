package br.com.avf.pss.checkin.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avf.pss.checkin.entity.CheckIn;
import br.com.avf.pss.checkin.repository.CheckInRepository;
import br.com.avf.pss.checkin.service.CheckInService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CheckInServiceImpl implements CheckInService {

	private final CheckInRepository repository;
	private final SenderService sender;

	@Autowired
	public CheckInServiceImpl(final CheckInRepository repository, final SenderService sender) {
		this.repository = repository;
		this.sender = sender;
	}

	@Override
	public CheckIn getCheckIn(Long id) {
		return this.repository.getOne(id);
	}

	@Override
	public Long checkIn(CheckIn checkIn) {
		checkIn.setCheckInTime(Calendar.getInstance().getTime());
		log.info(">>> Save checkin");
		Long id = this.repository.save(checkIn).getId();
		log.info("<<< CheckIn saved!");
		log.info(">>> Sending booking id " + id);
		sender.send(id);
		log.info("<<< Message sent!");
		return id;
	}

}
