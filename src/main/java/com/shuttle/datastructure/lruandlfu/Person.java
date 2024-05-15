package com.shuttle.datastructure.lruandlfu;

/**
 * @author: Shuttle
 * @description: 自定义 Person 类，用于缓存测试使用
 */
public record Person(Long id, String name, Integer age) {

    public Person(String name, Integer age) {
        this(System.currentTimeMillis() + (long) (Math.random() * 1000), name, age);
    }

}
