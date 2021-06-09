package br.com.avf.pss.checkin.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avf.pss.checkin.entity.CheckIn;
import br.com.avf.pss.checkin.service.CheckInService;

@RestController
@CrossOrigin
@RequestMapping("/checkin")
public class CheckInResource {

	private final CheckInService checkinService;

	@Autowired
	public CheckInResource(final CheckInService checkinService) {
		this.checkinService = checkinService;
	}

	@GetMapping("/{id}")
	public CheckIn checkIn(@PathVariable Long id) {
		return this.checkinService.getCheckIn(id);
	}
	
	@PostMapping
	public Long checkIn(@RequestBody CheckIn checkIn) {
		return this.checkinService.checkIn(checkIn);
	}

}
