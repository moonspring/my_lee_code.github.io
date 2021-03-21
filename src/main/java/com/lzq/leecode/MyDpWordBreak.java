package com.lzq.leecode;

import java.util.*;

public class MyDpWordBreak {

    public static void main(String[] args) {
        MyDpWordBreak myDpWordBreak = new MyDpWordBreak();

//        String s = "pineapplepenapple";
//        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        System.out.println("原字符串---------------");
        System.out.println("s="+s);
        System.out.println("原字符串长度---------------");
        System.out.println("s.length()="+s.length());
        System.out.println("---------------");

        System.out.println("字典---------------");
        wordDict.forEach(System.out::println);

        List<String> res = myDpWordBreak.wordBreak(s, wordDict);
        res.forEach(System.out::println);
    }


    int count = 0;

    /**
     * 动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {

        // 为了快速判断一个单词是否在单词集合中，需要将它们加入哈希表
        Set<String> wordDictSet = new HashSet<>(wordDict);

        int len = s.length();

        // 第 1 步：动态规划计算是否有解
        // dp[i] 表示「长度」为 i 的 s 前缀子串可以拆分成 wordDict 中的单词
        // 长度包括 0 ，因此状态数组的长度为 len + 1
        boolean[] dp = new boolean[len + 1];
        // 0 这个值需要被后面的状态值参考，如果一个单词正好在 wordDict 中，dp[0] 设置成 true 是合理的
        dp[0] = true;

        char[] chars = s.toCharArray();

        for (int right = 1; right <= len; right++) {

            // 如果单词集合中的单词长度都不长，从后向前遍历是更快的
            for (int left = right - 1; left >= 0; left--) {

                // substring 不截取 s[right]，dp[left] 的结果不包含 s[left]
                String temp = String.valueOf(chars,left,right-left);

                if (wordDictSet.contains(temp) && dp[left]) {
                    dp[right] = true;
                    System.out.println(String.format("right=%s;left=%s;str=%s",right,left,temp));
                    // 这个 break 很重要，一旦得到 dp[right] = True ，不必再计算下去
                    break;
                }
            }
        }

        // 第 2 步：回溯算法搜索所有符合条件的解
        int countFlag = 0;
        List<String> res = new ArrayList<>();
        if (dp[len]) {
            Deque<String> path = new ArrayDeque<>();

            for (boolean b : dp) {
                if (b){ System.out.println((String.valueOf(true)+ (countFlag))); }
                countFlag++;
            }
            System.out.println(" ");

            dfs(chars, len, wordDictSet, dp, path, res);
            return res;
        }
        return res;
    }

    /**
     * s[0:len) 如果可以拆分成 wordSet 中的单词，把递归求解的结果加入 res 中
     *
     * @param chars
     * @param len     长度为 len 的 s 的前缀子串
     * @param wordSet 单词集合，已经加入哈希表
     * @param dp      预处理得到的 dp 数组
     * @param path    从叶子结点到根结点的路径
     * @param res     保存所有结果的变量
     */
    private void dfs(char[] chars, int len, Set<String> wordSet, boolean[] dp, Deque<String> path, List<String> res) {
        if (len == 0) {
            res.add(String.join(" ",path));
            System.out.println(res);
            return;
        }

        // 可以拆分的左边界从 len - 1 依次枚举到 0
        for (int i = len - 1; i >= 0; i--) {
            String suffix = String.valueOf(chars,i,len-i);
            if (wordSet.contains(suffix) && dp[i]) {
                path.addFirst(suffix);
                System.err.println("第"+(++count)+"层递归:len="+len+";dp[len]="+dp[len]+";匹配的path="+path);
                dfs(chars, i, wordSet, dp, path, res);
                System.err.println("after递归:len="+len+";dp[len]="+dp[len]+";匹配的path="+path);
                path.removeFirst();
            }
        }
    }

}
