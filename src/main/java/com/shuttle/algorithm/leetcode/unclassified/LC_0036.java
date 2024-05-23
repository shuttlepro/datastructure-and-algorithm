package com.shuttle.algorithm.leetcode.unclassified;

/**
 * @author: Shuttle
 * @description: 请你判断一个 9 x 9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class LC_0036 {

    /**
     * 思路：利用三个二维数组辅助判断数独是否有效
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     *
     * @param board 未填充的数独二维数组
     * @return 数独是否有效
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        // 每一行的每个数是否出现过
        int[][] row = new int[9][9];
        // 每一列的每个数是否出现过
        int[][] column = new int[9][9];
        // 每一个 box 的每个数是否出现过
        int[][] box = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int curNum = board[i][j] - '1';
                if (row[i][curNum] == 1) {
                    return false;
                }
                if (column[j][curNum] == 1) {
                    return false;
                }
                int boxIndex = j / 3 + (i / 3) * 3;
                if (box[boxIndex][curNum] == 1) {
                    return false;
                }
                row[i][curNum] = 1;
                column[j][curNum] = 1;
                box[boxIndex][curNum] = 1;
            }
        }

        return true;
    }

}
