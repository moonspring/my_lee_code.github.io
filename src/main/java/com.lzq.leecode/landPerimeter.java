package com.lzq.leecode;

/**
 * 岛屿周长问题
 */
public class landPerimeter {

    public static void main(String[] args) {





    }

    public static int islandPerimeter(int[][] grid) {

        int x = grid.length;
        int y = grid[0].length;

        int result = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                if (grid[i][j]==1){

                    result += 4;
                    if (j+1<y && grid[i][j+1]==1){
                        result-=2;
                    }

                    if (i+1<x && grid[i+1][j]==1){
                        result-=2;
                    }
                }

            }
        }

        return result;
    }












}
