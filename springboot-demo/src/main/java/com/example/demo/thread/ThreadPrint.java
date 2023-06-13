package com.example.demo.thread;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2023/6/13 4:07 PM
 */
public class ThreadPrint {

    public static Integer count = 0;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (this) {
                        if (count % 2 == 1) {
                            System.out.println("Thread-1:" + count++);
                        }
                        notify();
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (this) {
                        if (count % 2 == 0) {
                            System.out.println("Thread-2:" + count++);
                        }
                        this.notify();
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();

    }

}
