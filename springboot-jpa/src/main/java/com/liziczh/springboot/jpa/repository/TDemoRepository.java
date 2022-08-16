package com.liziczh.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.liziczh.springboot.jpa.entity.TDemo;

@Repository
public interface TDemoRepository extends JpaRepository<TDemo, Long> {

    List<TDemo> findByName(String name);

}
