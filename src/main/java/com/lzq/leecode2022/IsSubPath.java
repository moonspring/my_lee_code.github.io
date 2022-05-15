package com.lzq.leecode2022;

/**
 *
 * 1367. 二叉树中的列表
 *
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 *
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 *
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径
 *
 * @author liuzhengquan
 * @date 2022/05/13 15:26
 **/
public class IsSubPath {

    public boolean isSubPath(ListNode head, TreeNode root) {

        //满足条件，直接返回true。
        if (head == null) {
            return true;
        }

        //能执行到这里说明head不为空，此时root为空的话不可能有正确结果，直接返回false。
        if (root == null){
            return false;
        }

        //这里可能比较难以理解，这里是调用了一个DfsSame和两个isSubPath.
        //DfsSame的含义大家可以看下面，注释很详细。
        //isSubPath就是当前的这个方法，所干的事情就是深度优先遍历DFS，他利用本身这个方法调用，来遍历root中每一个节点。
        //所以总结一下就是两个isSubPath用来遍历当前位置的左右子树。
        //一个DfsSame判断当前的root节点的值是否与head的第一个节点的值相同。
        //在本方法中调用的DfsSame，root节点比较的永远是head第一个节点的值，也必须比较head第一个节点的值。
        //判断head后续节点的值需要的前提条件是之前的节点已经找到了连续向下的路径。
        return dfSame(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }

    /**
     * 判断当前root节点与当前head节点的内容是否相同。
     * @param head
     * @param root
     * @return
     */
    private boolean dfSame(ListNode head , TreeNode root){

        // 则说明head已经遍历完毕，已经root中寻找到了与head相同连接向下的路径
        if (head == null){
            return true;
        }

        // head不为空，但root以为空，在此路径上不可能寻找到相同路径了，返回false
        if (root == null){
            return false;
        }

        //值不同，直接返回false
        if (root.val != head.val){
            return false;
        }

        //当前位置相同，root向下（向下寻找左右子树），head向后寻找下一个节点
        return dfSame(head.next,root.left) || dfSame(head.next,root.right);
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Definition for a binary tree node.
     */
     public class TreeNode {

         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

}
