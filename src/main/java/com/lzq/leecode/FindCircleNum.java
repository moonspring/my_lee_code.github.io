package com.lzq.leecode;

/**
 * LeeCode
 * <p>
 * 547. 省份数量
 * 解法一：深度优先搜索
 * @author lzq
 */
public class FindCircleNum {

    public static void main(String[] args) {

//        FindCircleNum findCircleNum = new FindCircleNum();
        FindCircleNum2 findCircleNum = new FindCircleNum2();

        int[][] param = {{1,1,0},{1,1,0},{0,0,1}};

        int result = findCircleNum.findCircleNum(param);

        System.out.println(result);

    }

    public int findCircleNum(int[][] isConnected) {

        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;

        for (int i = 0; i < provinces; i++) {

            if (!visited[i]) {
                dfs(isConnected, visited, provinces, i);
                circles++;
            }
        }
        return circles;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {

        for (int j = 0; j < provinces; j++) {

            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }

}
