package com.liziczh.springboot.kafka.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.util.CollectionUtils;

@Configuration
public class KafkaConfig {
    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;

    @Autowired
    private KafkaInitConfig kafkaInitConfig;

    @PostConstruct
    private void createTopic() {
        if (!CollectionUtils.isEmpty(kafkaInitConfig.getTopics())) {
            List<NewTopic> newTopics = new ArrayList<>();
            for (TopicInitDTO topic : kafkaInitConfig.getTopics()) {
                // 初始化topics
                NewTopic newTopic = new NewTopic(topic.getTopicName(), topic.getPartitionNum(),
                        topic.getReplicationFactor());
                newTopics.add(newTopic);
            }
            AdminClient client = adminClient();
            client.createTopics(newTopics);
            client.close();
        }
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>(1);
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        KafkaAdmin admin = new KafkaAdmin(configs);
        admin.setFatalIfBrokerNotAvailable(true);
        admin.setAutoCreate(true);
        return admin;
    }

    @Bean
    public AdminClient adminClient() {
        return AdminClient.create(kafkaAdmin().getConfigurationProperties());
    }

}
