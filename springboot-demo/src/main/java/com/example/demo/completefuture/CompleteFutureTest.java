package com.example.demo.completefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Lists;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompleteFutureTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(UUID.randomUUID().toString());
        }

        List<CompletableFuture> futureList = new ArrayList<>();
        Lists.partition(list, 10).forEach(group -> {

            CompletableFuture<AtomicInteger> future = CompletableFuture.supplyAsync(() -> {
                AtomicInteger count = new AtomicInteger();
                log.info("runAsync start");
                for (String s : group) {
                    log.info(s);
                    count.getAndIncrement();
                    try {
                        Thread.sleep(RandomUtil.randomInt(0, 500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("runAsync end");
                return count;
            });

            futureList.add(future);
            log.info("runAsync end2");
        });

        try {
            log.info("allOf start");
            CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).get();
            log.info("allOf End");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

}
