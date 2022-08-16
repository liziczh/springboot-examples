package com.liziczh.springboot.kafka.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "spring.kafka.init")
public class KafkaInitConfig {

    private List<TopicInitDTO> topics;

}
