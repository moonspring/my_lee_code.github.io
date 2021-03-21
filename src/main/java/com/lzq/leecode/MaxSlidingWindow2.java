package com.lzq.leecode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeeCode
 *
 * 239. 滑动窗口最大值
 *
 * 解法二：大顶堆
 * @author lzq
 */
public class MaxSlidingWindow2 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;

        /** 大顶堆的构造规则：新加入元素时，若新元素大，则放上面；若新元素小，新的在上面*/
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (part1, part2) -> part1[0]!=part2[0]?part2[0]-part1[0]:part2[1]-part1[1]
        );

        /** 首次构建一个大顶堆 */
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[len - k + 1];
        /** 读取一个元素（并不删除）：取出堆顶元素即为最大值 */
        ans[0] = pq.peek()[0];

        /** 其他元素进入堆中，构造大顶堆 */
        for (int i = k; i < len; ++i) {

            /** 再添加一个元素，到大顶堆中，大顶堆的序号，是左边第一个元素，则去掉该顶元素 */
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            /**剩下的元素，堆顶即为该滑动窗口最大的元素*/
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
