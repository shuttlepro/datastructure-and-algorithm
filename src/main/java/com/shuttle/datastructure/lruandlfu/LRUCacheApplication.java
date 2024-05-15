package com.shuttle.datastructure.lruandlfu;

/**
 * @author: Shuttle
 * @description: LRU Cache 测试类
 */
public class LRUCacheApplication {

    public static void main(String[] args) {
        LRUCache<String, Person> lruCache = new LRUCache<>(4);
        System.out.println("size: " + lruCache.getSize() + ", freeCapacity: " + lruCache.getFreeCapacity());
        // size: 0, freeCapacity: 4
        PersonCacheUtils.addPersonsToCache(lruCache, 2);
        System.out.println("size: " + lruCache.getSize() + ", freeCapacity: " + lruCache.getFreeCapacity());
        // size: 2, freeCapacity: 2
        lruCache.printCacheNodes();
        /**
         * CacheKey: Person_1711262106797, CacheValue: Person{id=1711262106797, name='Person-e4eb', age=16}
         *    <=>
         * CacheKey: Person_1711262106916, CacheValue: Person{id=1711262106916, name='Person-b24b', age=31}
         */
        PersonCacheUtils.addPersonsToCache(lruCache, 2);
        System.out.println("size: " + lruCache.getSize() + ", freeCapacity: " + lruCache.getFreeCapacity());
        // size: 4, freeCapacity: 0
        lruCache.printCacheNodes();
        /**
         * CacheKey: Person_1711262106797, CacheValue: Person{id=1711262106797, name='Person-e4eb', age=16}
         *    <=>
         * CacheKey: Person_1711262106916, CacheValue: Person{id=1711262106916, name='Person-b24b', age=31}
         *    <=>
         * CacheKey: Person_1711262107050, CacheValue: Person{id=1711262107050, name='Person-4624', age=32}
         *    <=>
         * CacheKey: Person_1711262106635, CacheValue: Person{id=1711262106635, name='Person-33b1', age=42}
         */
        PersonCacheUtils.addPersonsToCache(lruCache, 2);
        lruCache.printCacheNodes();
        /**
         * CacheKey: Person_1711262107050, CacheValue: Person{id=1711262107050, name='Person-4624', age=32}
         *    <=>
         * CacheKey: Person_1711262106635, CacheValue: Person{id=1711262106635, name='Person-33b1', age=42}
         *    <=>
         * CacheKey: Person_1711262107223, CacheValue: Person{id=1711262107223, name='Person-4c21', age=34}
         *    <=>
         * CacheKey: Person_1711262106792, CacheValue: Person{id=1711262106792, name='Person-f540', age=56}
         */
        System.out.println(lruCache.get(lruCache.getFirstKey())); // Person{id=1711262107050, name='Person-4624', age=32}
        lruCache.printCacheNodes();
        /**
         * CacheKey: Person_1711262106635, CacheValue: Person{id=1711262106635, name='Person-33b1', age=42}
         *    <=>
         * CacheKey: Person_1711262107223, CacheValue: Person{id=1711262107223, name='Person-4c21', age=34}
         *    <=>
         * CacheKey: Person_1711262106792, CacheValue: Person{id=1711262106792, name='Person-f540', age=56}
         *    <=>
         * CacheKey: Person_1711262107050, CacheValue: Person{id=1711262107050, name='Person-4624', age=32}
         */
    }

}
