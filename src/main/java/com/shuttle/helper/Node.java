package com.shuttle.helper;

import java.util.List;

/**
 * @author: Shuttle
 * @description: N 叉树节点 Node
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
