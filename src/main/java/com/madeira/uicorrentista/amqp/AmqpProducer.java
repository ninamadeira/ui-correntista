package com.madeira.uicorrentista.amqp;

public interface AmqpProducer<T> {
	void producer(T t);

}
