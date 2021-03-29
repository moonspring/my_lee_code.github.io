package com.lzq.type.tree;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 *
 * 二叉树的层次遍历----java实现
 * @author adam
 */
public class LevelOrder {

    public void levelIterator(BiTree root){
        if (root==null){
            return;
        }
        BiTree current;
        LinkedList<BiTree> queue = new LinkedList<>();
//        ArrayDeque<BiTree> queue = new ArrayDeque<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            /**出队队头元素并访问*/
            current = queue.poll();
            System.out.print(current.val +"-->");
            /**如果当前节点的左节点不为空入队*/
            if (root.left!=null){
                queue.offer(current.left);
            }
            /**如果当前节点的右节点不为空，把右节点入队*/
            if (root.right!=null){
                queue.offer(current.right);
            }
        }
    }

    @Data
    class BiTree{
        private int val;
        private BiTree left;
        private BiTree right;
    }
}
