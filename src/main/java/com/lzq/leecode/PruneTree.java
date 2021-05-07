package com.lzq.leecode;

/**
 * LeeCode
 * 814. 二叉树剪枝
 *
 * @author adam
 */
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root)?root:null;
    }


    public boolean containsOne(TreeNode node){
        if (node==null){
            return false;
        }
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        if (!a1){
            node.left = null;
        }
        if (!a2){
            node.right = null;
        }
        return node.val ==1 || a1 || a2;
    }




    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
