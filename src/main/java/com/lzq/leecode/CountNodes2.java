package com.lzq.leecode;

/**
 * LeeCode
 *
 * 222. 完全二叉树的节点个数
 *
 * 解法二：二分查找 + 位运算
 */
public class CountNodes2 {


    public int countNodes(CountNodes.TreeNode root) {

        if (root == null) {
            return 0;
        }
        int level = 0;
        CountNodes.TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(CountNodes.TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        CountNodes.TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
