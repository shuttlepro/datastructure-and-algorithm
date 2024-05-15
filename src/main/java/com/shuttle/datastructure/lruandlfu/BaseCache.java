package com.shuttle.datastructure.lruandlfu;

/**
 * @author: Shuttle
 * @description: BaseCache
 */
public interface BaseCache<K, V> {

    /**
     * 将 <Key, Val> 组装成 Node 节点放入 Cache 中
     *
     * @param key CacheKey
     * @param val CacheValue
     */
    void put(K key, V val);

    /**
     * 获取指定 CacheKey 对应的 Value，不存在返回 null
     *
     * @param key CacheKey
     * @return CacheValue
     */
    V get(K key);

    /**
     * Cache 实际的数据结构
     *
     * @param <K> Cache Key
     * @param <V> Cache Value
     */
    class DoubleLinkedList<K, V> {

        Node<K, V> head;
        Node<K, V> tail;

        DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 添加节点到链表的末尾
         *
         * @param node 待添加的节点
         */
        void addLast(Node<K, V> node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }

        /**
         * 删除指定节点
         *
         * @param node 待删除的节点
         */
        void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void prettyPrint() {
            Node<K, V> current = head.next;

            while (current != tail) {
                System.out.print("CacheKey: " + current.key + ", CacheValue: " + current.val);
                current = current.next;
                if (current != tail) {
                    System.out.println();
                    System.out.print("   <=>   ");
                }
                System.out.println();
            }
        }

    }

    /**
     * DoubleLinkedList 中实际存储的元素类型
     *
     * @param <K> Node Key
     * @param <V> Node Value
     */
    class Node<K, V> {

        K key;
        V val;
        Node<K, V> next;
        Node<K, V> prev;

        Node() {
        }

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

    }

}
