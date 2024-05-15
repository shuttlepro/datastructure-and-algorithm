package com.shuttle.datastructure.prefixtree;

/**
 * @author: Shuttle
 * @description: 前缀树测试
 */
public class PrefixTreeApplication {
    public static void main(String[] args) {
        PrefixTree tree = new PrefixTree();
        tree.addElement("apple");
        tree.addElement("banana");
        tree.addElement("app");
        tree.addElement("bat");
        tree.addElement("ball");
        tree.addElement("cat");
        tree.printTree();
        /**
         * app
         * apple
         * ball
         * banana
         * bat
         * cat
         */
        System.out.println(tree.isExistElement("ap")); // false
        System.out.println(tree.isExistElement("app")); // true
    }

}
