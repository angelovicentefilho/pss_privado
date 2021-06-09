package br.com.avf.pss.checkin.service;

import br.com.avf.pss.checkin.entity.CheckIn;

public interface CheckInService {

	CheckIn getCheckIn(Long id);

	Long checkIn(CheckIn checkIn);

}
