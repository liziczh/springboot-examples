package com.liziczh.springboot.kafka;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liziczh.springboot.kafka.kafka.consumer.ConsumerListener;
import com.liziczh.springboot.kafka.kafka.producer.KafkaProducer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = SpringbootKafkaApplication.class)
@SpringBootTest
@ActiveProfiles("test")
public class SpringbootKafkaApplicationTests {
	@Autowired
	private KafkaProducer producer;
	@Autowired
	private ConsumerListener listener;

	@Test
	void produce() {
		producer.sendMsg("archetypeTopic", "123456");
	}
	@Test
	void consume() {
	}

}
