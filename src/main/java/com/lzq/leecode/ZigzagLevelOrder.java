package com.lzq.leecode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LeeCode
 *
 * 103. 二叉树的锯齿形层序遍历
 *
 * 解法一：左优先栈和右优先栈
 * @author lzq
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
//          3
//         / \
//        9  20
//         /  \
//        15   7
        TreeNode treeNode = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        /** 栈*/
        Deque<TreeNode> leftFirstStack = new LinkedList();
        Deque<TreeNode> rightFirstStack = new LinkedList();

        leftFirstStack.add(root);

        while (!leftFirstStack.isEmpty() || !rightFirstStack.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            if (rightFirstStack.isEmpty()){
                while (!leftFirstStack.isEmpty()){
                    TreeNode temp = leftFirstStack.peek();
                    tempList.add(temp.val);
                    if (temp.left!=null){
                        rightFirstStack.push(temp.left);
                    }
                    if (temp.right!=null){
                        rightFirstStack.push(temp.right);
                    }
                    leftFirstStack.pop();
                }
            }else {
                while (!rightFirstStack.isEmpty()){
                    TreeNode temp = rightFirstStack.peek();
                    tempList.add(temp.val);
                    if (temp.right!=null){
                        leftFirstStack.push(temp.right);
                    }
                    if (temp.left!=null){
                        leftFirstStack.push(temp.left);
                    }
                    rightFirstStack.pop();
                }
            }
            ans.add(tempList);
        }
        return ans;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
