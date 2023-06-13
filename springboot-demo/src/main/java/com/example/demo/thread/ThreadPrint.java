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


    public static void main(String[] args) {
        Task task = new Task();
        new Thread(task, "Thread-1").start();
        new Thread(task, "Thread-2").start();
    }

}
