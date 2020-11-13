package com.liziczh.java8.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("匿名内部类创建线程。。。");
			}
		}).start();
		new Thread(() -> {
			System.out.println("lambda表达式");
		});
		List<String> list = new ArrayList<>();
		list.stream().filter(element -> element.equals(" ")).collect(Collectors.toList());
	}
}
