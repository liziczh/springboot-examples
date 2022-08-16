package com.liziczh.springboot.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.liziczh.springboot.jpa.entity.TDemo;
import com.liziczh.springboot.jpa.repository.TDemoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaTest {
    @Autowired
    private TDemoRepository demoRepository;

    @Test
    public void insertTest() {
        TDemo entity = new TDemo();
        entity.setId(0L);
        entity.setCreateTime(new Date());
        entity.setCreateUser("");
        entity.setUpdateTime(new Date());
        entity.setUpdateUser("");
        entity.setVersion(0);
        entity.setIsDel(0);
        entity.setDemoId(0L);
        entity.setName("liziczh");
        entity.setDesc("liziczh");
        TDemo result = demoRepository.saveAndFlush(entity);
        log.info("insertTest, result={}", result);
    }

    @Test
    public void updateTest() {
        TDemo entity = new TDemo();
        entity.setId(71L);
        entity.setCreateTime(new Date());
        entity.setCreateUser("");
        entity.setUpdateTime(new Date());
        entity.setUpdateUser("");
        entity.setVersion(0);
        entity.setIsDel(0);
        entity.setDemoId(0L);
        entity.setName("liziczh2");
        entity.setDesc("liziczh2");
        TDemo result = demoRepository.save(entity);
        log.info("updateTest, result={}", result);
    }

    @Test
    public void getTest() {
        TDemo demo = demoRepository.findById(0L).get();
        log.info("getTest, demo={}", demo);
    }

    @Test
    public void selectByConditionTest() {
        TDemo entity = new TDemo();
        entity.setName("liziczh");
        List<Sort.Order> sortOrderList = new ArrayList<>();
        Sort.Direction direction = Sort.Direction.DESC;
        sortOrderList.add(new Sort.Order(direction, "createTime"));
        PageRequest pageRequest = PageRequest.of(1, 10, Sort.by(sortOrderList));
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<TDemo> example = Example.of(entity, matcher);
        Page<TDemo> page = demoRepository.findAll(example, pageRequest);
        log.info("getTest, page={}", page);
    }

    @Test
    public void delTest() {
        demoRepository.deleteById(0L);
    }
}
