package com.shuttle.datastructure.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/simplify-path/description">简化路径</a>
 */
public class LC_0071 {

    /**
     * 利用 ArrayDeque 数据结构作为栈使用，遇到不同的字符串进行判断，遇到 "." / "" 直接跳过，
     * 遇到 ".." 需要判断栈中是否有元素，有则弹出最后一次添加的元素，最后把栈元素拼接成字符串返回即可
     * 时间复杂度：O(n)，n 是路径字符串长度
     * 空间复杂度：O(n)
     *
     * @param path 路径字符串
     * @return 简化后的路径字符串
     */
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return "";
        }

        // path = "/a/./b/../../c/"
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String str : paths) {
            // 碰到 "." / "" 直接跳过
            if (".".equals(str) || "".equals(str)) {
                continue;
            } else if ("..".equals(str)) {
                // 如果是 ".." 需要判断中是否有元素，有则弹出最后一次添加的元素
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                // 把元素添加到栈尾部
                stack.addLast(str);
            }
        }

        // 栈空直接返回 "/"
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder simplifyPath = new StringBuilder("/");
        while (!stack.isEmpty()) {
            simplifyPath.append(stack.pop()).append("/");
        }
        simplifyPath.setLength(simplifyPath.length() - 1);

        return simplifyPath.toString();
    }

}
