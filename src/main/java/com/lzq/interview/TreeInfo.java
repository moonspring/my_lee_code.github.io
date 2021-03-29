package com.lzq.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数组存储二叉树，求第n个元素的大小
 * @author adam
 */
public class TreeInfo {

    public Integer nMax1(Integer[] binaryTree,int n){
        if (binaryTree.length<n){return -1;}
        List<Integer> res = new ArrayList<>();
        int size = binaryTree.length;
        preOrder(res,binaryTree,0,size);
        res.forEach(System.out::println);
        return res.size()<n?-1:res.get(size-n);
    }

    /**先序遍历*/
    private void preOrder(List<Integer> res,Integer[] binaryTree,int index,int size) {
        if (binaryTree[index]!=null){
            res.add(binaryTree[index]);
        }
        int left = index * 2 + 1;
        if (left < size) {
            preOrder(res,binaryTree,left,size);
        }
        int right = index * 2 + 2;
        if (right < size) {
            preOrder(res,binaryTree,right,size);
        }
    }

    public Integer nMax2(Integer[] binaryTree,int n){
        List<Integer> ls = Arrays.stream(binaryTree)
                .filter(item->item!=null)
                .sorted((o1, o2) -> o2-o1).collect(Collectors.toList());
        return ls.size()<n?-1:ls.get(n);
    }
}
