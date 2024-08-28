package com.shuttle.algorithm.leetcode.slidingwindow;

/**
 * @author: Shuttle
 * @description: <a href="https://leetcode.cn/problems/minimum-window-substring/description">最小覆盖子串</a>
 */
public class LC_0076 {

    /**
     * 思路：滑动窗口
     * 时间复杂度：O(s + t)，s 是字符串 s 的长度，t 是字符串 t 的长度
     * 空间复杂度：O(1)，两个数组 need 和 have，常数级别
     *
     * @param s 字符串 s
     * @param t 字符串 t
     * @return 返回 s 中涵盖的最小子串，如果不存在则返回空字符串
     */
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        // 维护两个数组，记录已有字符串指定字符的出现次数，和目标字符串指定字符的出现次数，len 参考 ASCII 表长
        int[] need = new int[128];
        int[] have = new int[128];

        // 统计目标字符串 t 中各个字符的出现次数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        // 定义左、右指针，最小长度、已有字符串中目标字符串指定字符的出现总频次以及最小覆盖子串在原字符串中的起始位置
        int left = 0, right = 0, min = s.length() + 1, count = 0, start = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            // 说明该字符不被目标字符串需要，此时有两种情况
            // 1.循环刚开始，那么直接移动右指针即可，不需要做多余判断
            // 2.循环已经开始一段时间，此处又有两种情况
            //  2.1 上一次条件不满足，已有字符串指定字符出现次数不满足目标字符串指定字符出现次数，那么此时
            //      如果该字符还不被目标字符串需要，就不需要进行多余判断，右指针移动即可
            //  2.2 左指针已经移动完毕，那么此时就相当于循环刚开始，同理直接移动右指针
            if (need[r] == 0) {
                right++;
                continue;
            }
            // 当已有字符串目标字符出现的次数小于目标字符串字符的出现次数时，count++
            if (have[r] < need[r]) {
                count++;
            }
            // 更新已有字符频次
            have[r]++;
            right++;

            // 当且仅当已有字符串已经包含了所有目标字符串的字符，且出现频次一定大于或等于指定频次
            while (count == t.length()) {
                // 当窗口的长度比已有的最小长度值小时，更改最小值，并记录起始位置
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                char l = s.charAt(left);
                // 如果左边即将要去掉的字符不被目标字符串需要，移动左指针
                if (need[l] == 0) {
                    left++;
                    continue;
                }
                // 如果左边即将要去掉的字符被目标字符串需要，且出现的频次正好等于指定频次，那么如果去掉了这个字符，
                // 就不满足覆盖子串的条件，此时要破坏循环条件跳出循环，即控制目标字符串指定字符的出现总频次(count）-1
                if (have[l] == need[l]) {
                    count--;
                }
                // 更新左边字符频次并移动左指针
                have[l]--;
                left++;
            }
        }
        // 如果最小长度还为初始值，说明没有符合条件的子串
        if (min == s.length() + 1) {
            return "";
        }
        // 返回以 start 为起点，min 为长度的子串
        return s.substring(start, start + min);
    }

}
