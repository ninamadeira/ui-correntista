package com.madeira.uicorrentista.services;

import com.madeira.uicorrentista.dto.CorrentistaNewDTO;

public interface AmqpService {
	void sendToConsumer(CorrentistaNewDTO correntistaNewDTO);

}
