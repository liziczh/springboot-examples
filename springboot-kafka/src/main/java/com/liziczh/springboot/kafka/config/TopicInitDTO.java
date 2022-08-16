package com.liziczh.springboot.kafka.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/8/16 4:06 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class TopicInitDTO {
    private String topicName;
    private Integer partitionNum;
    private Short replicationFactor;
}