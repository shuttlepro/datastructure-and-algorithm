package com.shuttle.datastructure.lruandlfu;

/**
 * @author: Shuttle
 * @description: LFU Cache 测试类
 */
public class LFUCacheApplication {
    public static void main(String[] args) {
        LFUCache<String, Person> lfuCache = new LFUCache<>(4);
        System.out.println("size: " + lfuCache.getSize() + ", freeCapacity: " + lfuCache.getFreeCapacity());
        // size: 0, freeCapacity: 4
        PersonCacheUtils.addPersonsToCache(lfuCache, 2);
        System.out.println("size: " + lfuCache.getSize() + ", freeCapacity: " + lfuCache.getFreeCapacity());
        // size: 2, freeCapacity: 2
        lfuCache.printCacheNodes();
        /**
         * frequent: 1
         * CacheKey: Person_1711269533213, CacheValue: Person{id=1711269533213, name='Person-840a', age=19}
         *    <=>
         * CacheKey: Person_1711269533233, CacheValue: Person{id=1711269533233, name='Person-c7cb', age=14}
         */
        PersonCacheUtils.addPersonsToCache(lfuCache, 2);
        System.out.println("size: " + lfuCache.getSize() + ", freeCapacity: " + lfuCache.getFreeCapacity());
        // size: 4, freeCapacity: 0
        lfuCache.printCacheNodes();
        /**
         * frequent: 1
         * CacheKey: Person_1711269533213, CacheValue: Person{id=1711269533213, name='Person-840a', age=19}
         *    <=>
         * CacheKey: Person_1711269533233, CacheValue: Person{id=1711269533233, name='Person-c7cb', age=14}
         *    <=>
         * CacheKey: Person_1711269532769, CacheValue: Person{id=1711269532769, name='Person-5712', age=58}
         *    <=>
         * CacheKey: Person_1711269533111, CacheValue: Person{id=1711269533111, name='Person-258f', age=31}
         */
        PersonCacheUtils.addPersonsToCache(lfuCache, 2);
        lfuCache.printCacheNodes();
        /**
         * frequent: 1
         * CacheKey: Person_1711269532769, CacheValue: Person{id=1711269532769, name='Person-5712', age=58}
         *    <=>
         * CacheKey: Person_1711269533111, CacheValue: Person{id=1711269533111, name='Person-258f', age=31}
         *    <=>
         * CacheKey: Person_1711269533476, CacheValue: Person{id=1711269533476, name='Person-0415', age=38}
         *    <=>
         * CacheKey: Person_1711269533573, CacheValue: Person{id=1711269533573, name='Person-cd37', age=22}
         */
        System.out.println(lfuCache.get(lfuCache.getFirstKeyByFrequent(1))); // Person{id=1711269532769, name='Person-5712', age=58}
        lfuCache.printCacheNodes();
        /**
         * frequent: 1
         * CacheKey: Person_1711269533111, CacheValue: Person{id=1711269533111, name='Person-258f', age=31}
         *    <=>
         * CacheKey: Person_1711269533476, CacheValue: Person{id=1711269533476, name='Person-0415', age=38}
         *    <=>
         * CacheKey: Person_1711269533573, CacheValue: Person{id=1711269533573, name='Person-cd37', age=22}
         *
         * frequent: 2
         * CacheKey: Person_1711269532769, CacheValue: Person{id=1711269532769, name='Person-5712', age=58}
         */
        System.out.println(lfuCache.get(lfuCache.getFirstKeyByFrequent(2))); // Person{id=1711269532769, name='Person-5712', age=58}
        lfuCache.printCacheNodes();
        /**
         * frequent: 1
         * CacheKey: Person_1711269533111, CacheValue: Person{id=1711269533111, name='Person-258f', age=31}
         *    <=>
         * CacheKey: Person_1711269533476, CacheValue: Person{id=1711269533476, name='Person-0415', age=38}
         *    <=>
         * CacheKey: Person_1711269533573, CacheValue: Person{id=1711269533573, name='Person-cd37', age=22}
         *
         * frequent: 2
         *
         * frequent: 3
         * CacheKey: Person_1711269532769, CacheValue: Person{id=1711269532769, name='Person-5712', age=58}
         */
    }
}
