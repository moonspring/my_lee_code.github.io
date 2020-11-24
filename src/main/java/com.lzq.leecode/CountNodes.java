package com.lzq.leecode;

/**
 * LeeCode
 *
 * 222. 完全二叉树的节点个数
 */
public class CountNodes {



    private int count = 0;

    public int countNodes(TreeNode root) {

        if (root!=null){
            count++;
            countNodes(root.left);
            countNodes(root.right);
        }

        return count;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
