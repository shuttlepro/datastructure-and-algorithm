package com.shuttle.datastructure.prefixtree;

/**
 * @author: Shuttle
 * @description: 前缀树
 */
public class PrefixTree {

    /**
     * 存储下一级字符列表
     */
    private final PrefixTree[] children;

    /**
     * 是否末尾
     */
    private boolean isEnd;

    public PrefixTree() {
        children = new PrefixTree[26];
        isEnd = false;
    }

    /**
     * 添加元素到前缀树中
     *
     * @param element 待添加的元素
     */
    public void addElement(String element) {
        char[] elementChars = element.toCharArray();
        PrefixTree temp = this;

        for (char ch : elementChars) {
            int index = ch - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new PrefixTree();
            }
            temp = temp.children[index];
        }
        temp.isEnd = true;
    }

    /**
     * 判断前缀树中是否存在 element
     *
     * @param element 待查找的元素
     * @return 是否存在
     */
    public boolean isExistElement(String element) {
        PrefixTree node = searchPrefix(element);
        return node != null && node.isEnd;
    }

    private PrefixTree searchPrefix(String element) {
        PrefixTree temp = this;
        char[] elementChars = element.toCharArray();

        for (char ch : elementChars) {
            int index = ch - 'a';
            if (temp.children[index] == null) {
                return null;
            }
            temp = temp.children[index];
        }

        return temp;
    }

    /**
     * 打印前缀树
     */
    public void printTree() {
        printTreeHelper(this, "");
    }

    private void printTreeHelper(PrefixTree node, String prefix) {
        if (node.isEnd) {
            System.out.println(prefix);
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                printTreeHelper(node.children[i], prefix + (char) ('a' + i));
            }
        }
    }

}
