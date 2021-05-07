package com.lzq.interview;

import lombok.Data;

/**
 * 二叉树遍历,从根节点到叶子结点,各元素相加.问其何是否为指定值.
 * @author adam
 */
public class XiaoMi1 {
    @Data
    public class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int val;
    }
    public static boolean dfs(TreeNode root,int sum){
        if (root==null){
            return false;
        }else {
            return dfs(root,0,sum);
        }
    }
    public static boolean dfs(TreeNode node,int sum,int res){
        if (node.left!=null || node.right!=null){
            return dfs(node.left,sum+node.val,res) && dfs(node.right,sum+node.val,res);
        }else if (node.left!=null){
            return dfs(node.left,sum+node.val);
        }else if (node.right!=null){
            return sum+node.val==res;
        }
        return false;
    }
}
