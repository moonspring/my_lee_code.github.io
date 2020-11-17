package com.lzq.leecode;

/**
 * 6、Z字变换
 */
public class ZigZagConversion {

    public static void main(String[] args) {

        String s = "LEETCODEISHIRING";
        int numRows = 3;

        String str = ZigZagConversion.convert(s,numRows);

        System.out.println(str);
    }

    /**
     *
     * 以 V 字型为一个循环, 循环周期为
     *  n = (2 * numRows - 2) （2倍行数 - 头尾2个）
     *
     * 对于字符串索引值i,计算
     *  x = i % n 确定在循环周期中的位置
     *
     * 则行号
     *  y = min(x, n - x)
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            rows[i] = new StringBuilder();
        }

        /* 以V字型为一个循环。循环周期n=2 * numRows - 2  */
        int n = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {

            /* x = i % n 确定在循环周期中的位置，字符串索引值i   */
            int x = i % n;

            /* 行号 y = min(x, n - x) */
            int y = Math.min(x,n-x);
            rows[y].append(s.charAt(i));
        }
        return String.join("", rows);
    }

}






















