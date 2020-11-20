package com.lzq.leecode;

/**
 * LeeCode
 *
 * 1379. 找出克隆二叉树中的相同节点
 *
 * 解法：递归
 */
public class GetTargetCopy {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if (original == null || cloned==null){
            return null;
        }else if (original.val == target.val){
            return cloned;
        }

        // 递归左子树
        TreeNode res = getTargetCopy(original.left,cloned.left,target);

        /* res == null 遍历到了叶子结点，仍未找到 */
        if (res != null){
            return res;
        }
        // 递归右子树
        res = getTargetCopy(original.right,cloned.right,target);
        if (res != null){
            return res;
        }
        return null;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
