package com.liziczh.springboot.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.liziczh.springboot.kafka.producer.KafkaProducer;

@SpringBootTest
public class SpringBootKafkaApplicationTests {
    @Autowired
    private KafkaProducer producer;

    @Test
    void produce() {
        producer.sendMsg("archetypeTopic", "123456");
    }

}
