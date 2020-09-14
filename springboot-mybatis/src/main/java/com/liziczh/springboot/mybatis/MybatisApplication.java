package com.liziczh.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = { "com.liziczh.**.mybatis" })
@MapperScan("com.liziczh.**.mapper")
@EntityScan(basePackages = "com.liziczh.**.entity")
@EnableCaching
public class MybatisApplication {
	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}
}
