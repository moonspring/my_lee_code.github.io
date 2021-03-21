package com.lzq.leecode;

/**
 * LeeCode
 *
 * 861. 翻转矩阵后的得分
 * @author lzq
 */
public class MatrixScore {

    public static void main(String[] args) {

        MatrixScore matrixScore = new MatrixScore();

        int[][] A = new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int result= matrixScore.matrixScore(A);

        System.out.println(result);
    }

    public int matrixScore(int[][] A) {
        moveRows(A);
        moveColumn(A);
        int res = sum(A);
        return res;
    }
    /**
     * 移动行
     * @param A
     */
    private void moveRows(int[][] A){
        for (int[] arrays:A) {
            if (arrays[0]==0){
                for (int i = 0; i < arrays.length; i++) {
                    if (arrays[i]==0){ arrays[i]=1; } else { arrays[i]=0; }
                }
            }
        }
    }

    /**
     * 移动列
     */
    private void moveColumn(int[][] A){
        for (int i = 0; i < A[0].length; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j][i]==0){ count0++; }else { count1++; }
            }
            if (count0>count1){
                /** 列交换 */
                moveC(i,A);
            }
        }
    }

    private void moveC(int i,int[][] A){
        for (int j = 0; j < A.length; j++) {
            if (A[j][i]==0){ A[j][i]=1; }else { A[j][i]=0; }
        }
    }

    /**
     * 求和
     * @param A
     * @return
     */
    private int sum(int[][] A){
        int len = A[0].length;
        double sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = len-1; j >=0 ; j--) {
                if (A[i][j]==1){
                    sum+=Math.pow(2,len-j-1);
                }
            }
        }
        return (int)sum;
    }
}






















