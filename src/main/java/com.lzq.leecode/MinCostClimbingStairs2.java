package com.lzq.leecode;

/**
 * LeeCode
 *
 * 746. 使用最小花费爬楼梯
 *
 * 解法二：
 *
 * 因此状态转移方程是：
 *
 * dp[i] = min(dp[i-2], dp[i-1]) + cost[i]。
 *
 * 初始条件：
 * 最后一步踏上第0级台阶，最小花费dp[0] = cost[0]。
 *
 * 最后一步踏上第1级台阶有两个选择：
 *
     * 可以分别踏上第0级与第1级台阶，花费cost[0] + cost[1]；
     * 也可以从地面开始迈两步直接踏上第1级台阶，花费cost[1]。
     * 最小值dp[1] = min(cost[0] + cost[1], cost[1]) = cost[1]
 *
 * @author lzq
 */
public class MinCostClimbingStairs2 {

    public int minCostClimbingStairs(int[] cost){

        int size = cost.length;
        int[] dp = new int[size];
        dp[0] = cost[0];
        dp[1] = Math.min(cost[0]+cost[1],cost[1]);
        for (int i = 2; i < size; i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[size - 2], dp[size - 1]);
    }

}
