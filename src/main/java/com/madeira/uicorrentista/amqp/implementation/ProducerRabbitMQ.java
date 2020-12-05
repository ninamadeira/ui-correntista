package com.madeira.uicorrentista.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.madeira.uicorrentista.amqp.AmqpProducer;
import com.madeira.uicorrentista.dto.CorrentistaNewDTO;

@Component
public class ProducerRabbitMQ implements AmqpProducer<CorrentistaNewDTO> {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${spring.rabbitmq.request.routing-key.producer}")
	private String queue;

	@Value("${spring.rabbitmq.request.exchenge.producer}")
	private String exchange;

	@Override
	public void producer(CorrentistaNewDTO correntistaNewDTO) {
		try {
			rabbitTemplate.convertAndSend(exchange, queue, correntistaNewDTO);
		} catch (Exception ex) {
			throw new AmqpRejectAndDontRequeueException(ex);
		}
	}
}
