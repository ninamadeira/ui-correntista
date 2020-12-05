package com.madeira.uicorrentista.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.madeira.uicorrentista.dto.CorrentistaNewDTO;
import com.madeira.uicorrentista.services.AmqpService;

@RestController
public class CorrentistaResource {
	
	@Autowired
	private AmqpService service;

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/send")
	public void sendToConsumer(@Valid @RequestBody CorrentistaNewDTO correntistaNewDTO) {
		service.sendToConsumer(correntistaNewDTO);
	}

}
