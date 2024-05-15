package com.shuttle.datastructure.lruandlfu;

import java.util.Random;
import java.util.UUID;

/**
 * @author: Shuttle
 * @description: Person 工具类，用于辅助缓存测试使用
 */
public class PersonCacheUtils {

    private static final String CACHE_KEY_PREFIX = "Person_";

    private static final String PERSON_NAME_PREFIX = "Person-";

    public static void addPersonsToCache(BaseCache<String, Person> cache, int personCount) {
        Random random = new Random();

        for (int i = 0; i < personCount; i++) {
            String name = PERSON_NAME_PREFIX + UUID.randomUUID().toString().substring(0, 4);
            Integer age = 10 + random.nextInt(50);
            Person person = new Person(name, age);
            cache.put(getCacheKey(person.id()), person);
        }
    }

    public static String getCacheKey(Long id) {
        return CACHE_KEY_PREFIX + id;
    }

}
