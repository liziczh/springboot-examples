package com.liziczh.springboot.kafka.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ConsumerListener {
	@KafkaListener(topics = "archetypeTopic")
	public void process(String msg) {
		log.info(msg);
	}
}
