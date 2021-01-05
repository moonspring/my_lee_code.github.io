package com.lzq.leecode;

import java.util.*;

/**
 * LeeCode
 *
 * 面试题 08.12. 八皇后
 * 解法一
 * @author lzq
 */
public class SolveNsQueens {

    public static void main(String[] args) {

//        SolveNsQueens solveNsQueens = new SolveNsQueens();
        SolveNsQueens2 solveNsQueens = new SolveNsQueens2();

        List<List<String>> res = solveNsQueens.solveNQueens(8);

        for (List<String> item:res) {
            item.forEach(System.out::println);
            System.err.println("----------------------------");
        }
    }


    public List<List<String>> solveNQueens(int n) {

        List<List<String>> solutions = new ArrayList<>();

        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();

        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);

        return solutions;
    }

    public void backtrack(List<List<String>> solutions,
                          int[] queens,
                          int n,
                          int row,
                          Set<Integer> columns,
                          Set<Integer> diagonals1,
                          Set<Integer> diagonals2) {

        if (row == n) {
            /** 找到解，打印出来 */
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {

                /**判断条件一：是否在同一列。用列标表示 */
                if (columns.contains(i)) {
                    continue;
                }
                /**判断条件二：斜率为-1。行下标 与 列下标 的差相等 */
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                /**判断条件三：斜率为 1。行下标 与 列下标 的和相等 */
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }

                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);

                /** 搞下一列*/
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);

                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
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
