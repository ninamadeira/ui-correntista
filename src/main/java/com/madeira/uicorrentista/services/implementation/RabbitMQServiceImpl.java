package com.madeira.uicorrentista.services.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madeira.uicorrentista.amqp.AmqpProducer;
import com.madeira.uicorrentista.dto.CorrentistaNewDTO;
import com.madeira.uicorrentista.services.AmqpService;

@Service
public class RabbitMQServiceImpl implements AmqpService {

    @Autowired
    private AmqpProducer<CorrentistaNewDTO> amqp;

    @Override
    public void sendToConsumer(CorrentistaNewDTO correntistaNewDTO) {
        amqp.producer(correntistaNewDTO);
    }
}