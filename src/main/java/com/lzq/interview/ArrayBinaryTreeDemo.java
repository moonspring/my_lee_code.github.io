package com.lzq.interview;

/** 用数组实现顺序存储完全二叉树，并进行前序遍历中序遍历后序遍历
 *         1
 *       /  \
 *      2    3
 *     / \  /
 *    4  5 6
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] tree = {1, 2, 3, 4, 5, 6};
        ArrayBinaryTreeDemo arrayBinaryTreeDemo = new ArrayBinaryTreeDemo();
        arrayBinaryTreeDemo.preOrder(tree);   // 1 2 4 5 3 6
    }

    /**
     * 先序遍历
     */
    public void preOrder(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("树为空！");
            return;
        }
        preOrder(arr,0);
        System.out.println();
    }

    private void preOrder(int[] arr,int index) {
        System.out.print(arr[index] + " ");
        int left = index * 2 + 1;
        if (left < arr.length) {
            preOrder(arr,left);
        }
        int right = index * 2 + 2;
        if (right < arr.length) {
            preOrder(arr,right);
        }
    }
}