package com.example.demo.thread;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2023/6/13 6:42 PM
 */
public class Task implements Runnable {

    public Integer count = 0;

    @Override
    public void run() {
        while (count < 100) {
            synchronized (this) {
                System.out.println(count++);
                this.notify();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
