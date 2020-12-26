package com.lzq.leecode;

/**
 * LeeCode
 *
 * 85. 最大矩形
 *
 * @author lzq
 */
public class MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {

        if (matrix==null || matrix.length==0){return 0;}
        /** 行 */
        int rows = matrix.length;
        /** 列 */
        int column = matrix[0].length;

        int[][] left = new int[rows][column];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                res = Math.max(res, area);
            }
        }

        return res;
    }
}
