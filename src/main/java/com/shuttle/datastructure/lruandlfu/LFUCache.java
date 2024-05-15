package com.shuttle.datastructure.lruandlfu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author: Shuttle
 * @description: 自定义 LFU Cache
 */
public class LFUCache<K, V> implements BaseCache<K, V> {

    /**
     * 访问频率 1
     */
    private static final int FREQUENT_ONE = 1;

    /**
     * Cache 的容量
     */
    private final int capacity;

    /**
     * 使用无参构造器时 Cache 的默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Cache 当前大小
     */
    private int size;

    /**
     * 提供 CacheKey -> Node 的映射表，可以方便 O(1) 时间复杂度获取节点
     */
    private final Map<K, LFUNode<K, V>> keyToNodeMap;

    /**
     * <Frequent, CacheLinkedList> 映射表
     */
    private final Map<Integer, DoubleLinkedList<K, V>> freqLinkedListMap;

    /**
     * Cache 中最小的访问频次
     */
    private int minFrequent;

    /**
     * LFU Cache 无参构造器
     */
    public LFUCache() {
        this.capacity = DEFAULT_CAPACITY;
        keyToNodeMap = new HashMap<>();
        freqLinkedListMap = new TreeMap<>(Integer::compareTo);
        size = 0;
        minFrequent = 0;
    }

    /**
     * LFU Cache 有参构造器
     *
     * @param initialCapacity 初始容量
     */
    public LFUCache(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("initialCapacity needs to be greater than zero.");
        } else {
            this.capacity = initialCapacity;
        }
        keyToNodeMap = new HashMap<>();
        freqLinkedListMap = new HashMap<>();
        size = 0;
        minFrequent = 0;
    }

    /**
     * 将 <Key, Val> 组成节点放入 LFU Cache 中
     *
     * @param key CacheKey
     * @param val CacheValue
     */
    @Override
    public void put(K key, V val) {
        // 若该 Key 已经存在 Cache 链中则直接更新访问频次和缓存值
        LFUNode<K, V> node = keyToNodeMap.get(key);
        if (node != null) {
            node.val = val;
            increFrequent(node);
            return;
        }
        // 不存在则判断容量是否充足
        if (this.size >= this.capacity) {
            // 不充足则需要找到 minFrequent 对应的 Cache 链，移除队列首元素
            DoubleLinkedList<K, V> minFreqList = freqLinkedListMap.get(minFrequent);
            Node<K, V> firstNode = minFreqList.head.next;
            keyToNodeMap.remove(firstNode.key);
            minFreqList.remove(firstNode);
            size--;
        }
        // 添加节点到 FREQUENT_ONE 链中
        LFUNode<K, V> newNode = new LFUNode<>(key, val);
        keyToNodeMap.put(key, newNode);
        DoubleLinkedList<K, V> oneFreqList = freqLinkedListMap.get(FREQUENT_ONE);
        if (oneFreqList == null) {
            oneFreqList = new DoubleLinkedList<>();
            freqLinkedListMap.put(FREQUENT_ONE, oneFreqList);
        }
        oneFreqList.addLast(newNode);
        size++;
        minFrequent = FREQUENT_ONE;
    }

    /**
     * 获取指定 CacheKey 对应的 Value，不存在返回 null
     *
     * @param key CacheKey
     * @return CacheValue
     */
    @Override
    public V get(K key) {
        LFUNode<K, V> node = keyToNodeMap.get(key);
        if (node == null) {
            return null;
        }
        increFrequent(node);

        return node.val;
    }

    /**
     * 增加指定节点的访问频次
     *
     * @param node 待增加频次的节点
     */
    private void increFrequent(LFUNode<K, V> node) {
        // 先从原来频次的 Cache 链上删除该节点
        int originalFreq = node.frequent;
        DoubleLinkedList<K, V> originalFreqList = freqLinkedListMap.get(originalFreq);
        originalFreqList.remove(node);
        int newFreq = originalFreq + 1;
        // 如果 originalFreqList 中就这一个节点需要更新 minFrequent
        if (originalFreq == minFrequent && originalFreqList.head.next == originalFreqList.tail) {
            minFrequent = newFreq;
        }
        // 更新节点访问频次并将其添加到 originalFrq + 1 Cache 链中
        node.frequent = newFreq;
        DoubleLinkedList<K, V> newFreqList = freqLinkedListMap.get(newFreq);
        if (newFreqList == null) {
            newFreqList = new DoubleLinkedList<>();
            freqLinkedListMap.put(newFreq, newFreqList);
        }
        newFreqList.addLast(node);
    }

    public int getFreeCapacity() {
        return this.capacity - this.size;
    }

    public int getSize() {
        return this.size;
    }

    /**
     * 测试使用
     *
     * @return 返回 frequentCache 链上的第一个元素
     */
    public K getFirstKeyByFrequent(int frequent) {
        DoubleLinkedList<K, V> freqLinkedList = freqLinkedListMap.get(frequent);
        if (freqLinkedList == null) {
            return null;
        }
        Node<K, V> firstNode = freqLinkedList.head.next;
        if (firstNode == null) {
            return null;
        }
        return freqLinkedList.head.next.key;
    }

    public void printCacheNodes() {
        Set<Map.Entry<Integer, DoubleLinkedList<K, V>>> freqToDoubleLinkedListEntries = freqLinkedListMap.entrySet();
        for (Map.Entry<Integer, DoubleLinkedList<K, V>> freqToDoubleLinkedListEntry : freqToDoubleLinkedListEntries) {
            Integer frequent = freqToDoubleLinkedListEntry.getKey();
            DoubleLinkedList<K, V> doubleLinkedList = freqToDoubleLinkedListEntry.getValue();
            System.out.println("frequent: " + frequent);
            doubleLinkedList.prettyPrint();
            System.out.println();
        }
    }

    /**
     * LFUNode 需要 frequent 属性
     *
     * @param <K> CacheKey
     * @param <V> CacheValue
     */
    private static class LFUNode<K, V> extends BaseCache.Node<K, V> {

        int frequent;

        LFUNode(K key, V val) {
            super(key, val);
            this.frequent = FREQUENT_ONE;
        }

    }

}
