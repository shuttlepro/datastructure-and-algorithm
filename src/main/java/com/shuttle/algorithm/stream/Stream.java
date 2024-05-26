package com.shuttle.algorithm.stream;

import java.util.function.*;

/**
 * @author: Shuttle
 * @description: Custom stream interface
 */
public interface Stream<T> {

    /**
     * 将元素按照给定的形式收集到提供的容器实例中
     *
     * @param supplier 封装提供容器实例的函数对象
     * @param consumer 元素值按照指定逻辑添加到容器的函数对象
     * @return 返回收集元素的容器实例
     */
    <C> C collect(Supplier<C> supplier, BiConsumer<C, T> consumer);

    /**
     * 过滤元素
     *
     * @param predicate 封装过滤条件的函数对象
     * @return 返回过滤后的 Stream
     */
    Stream<T> filter(Predicate<T> predicate);

    /**
     * 将给定的对象按照给定逻辑进行转换
     *
     * @param function 封装对象转换逻辑的函数对象
     * @return 返回转换后的对象
     */
    <R> SimpleStream<R> map(Function<T, R> function);

    /**
     * 聚合 Stream 中的元素值
     *
     * @param prev     前一个聚合值
     * @param operator 封装聚合逻辑的函数对象
     * @return 返回聚合后的结果
     */
    T reduce(T prev, BinaryOperator<T> operator);

    /**
     * 对 Stream 中的元素进行指定逻辑的消费
     *
     * @param consumer 封装消费逻辑的函数对象
     */
    void forEach(Consumer<T> consumer);

}
