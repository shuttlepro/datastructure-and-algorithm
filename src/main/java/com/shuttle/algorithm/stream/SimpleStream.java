package com.shuttle.algorithm.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;

/**
 * @author: Shuttle
 * @description: Custom stream implementation
 */
public class SimpleStream<T> implements Stream<T> {

    private final Collection<T> collection;

    private SimpleStream(Collection<T> collection) {
        this.collection = collection;
    }

    public static <T> SimpleStream<T> of(Collection<T> collection) {
        return new SimpleStream<>(collection);
    }

    @Override
    public <C> C collect(Supplier<C> supplier, BiConsumer<C, T> consumer) {
        C c = supplier.get();
        for (T t : collection) {
            consumer.accept(c, t);
        }
        return c;
    }

    @Override
    public Stream<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : collection) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return new SimpleStream<>(result);
    }

    @Override
    public <R> SimpleStream<R> map(Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : collection) {
            R r = function.apply(t);
            result.add(r);
        }
        return new SimpleStream<>(result);
    }

    @Override
    public T reduce(T prev, BinaryOperator<T> operator) {
        T reduce = prev;
        for (T t : collection) {
            reduce = operator.apply(reduce, t);
        }
        return reduce;
    }

    @Override
    public void forEach(Consumer<T> consumer) {
        for (T t : collection) {
            consumer.accept(t);
        }
    }

}
