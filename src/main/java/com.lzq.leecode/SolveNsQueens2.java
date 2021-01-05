package com.lzq.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeeCode
 *
 * 面试题 08.12. 八皇后
 * 解法2 ：TODO：没搞懂
 * @author lzq
 */
public class SolveNsQueens2 {

    public List<List<String>> solveNQueens(int n) {

        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        List<List<String>> solutions = new ArrayList<>();
        solve(solutions,
                queens,
                n,
                0,
                0,
                0,
                0);
        return solutions;
    }

    public void solve(List<List<String>> solutions,
                      int[] queens,
                      int n,
                      int row,
                      int columns,
                      int diagonals1,
                      int diagonals2) {

        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));

            while (availablePositions != 0) {

                /** x & (−x) 可以获得x 的二进制表示中的最低位的1的位置*/
                int position = availablePositions & (-availablePositions);

                /** x & (x−1) 可以将x 的二进制表示中的最低位的1置成0*/
                availablePositions = availablePositions & (availablePositions - 1);

                int column = Integer.bitCount(position - 1);

                queens[row] = column;

                solve(solutions,
                        queens,
                        n,
                        row + 1,
                        columns | position,
                        (diagonals1 | position) << 1,
                        (diagonals2 | position) >> 1);

                queens[row] = -1;
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {

        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }


}
