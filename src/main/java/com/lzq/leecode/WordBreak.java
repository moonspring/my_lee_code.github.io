package com.lzq.leecode;


import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 记忆化搜索 is OK、动态规划 is also OK
 *
 * LeeCode
 * 140. 单词拆分 II
 * 140. 单词拆分 II
 */
public class WordBreak {

    /* 第一种解法：记忆化搜索—— 自己认为比较合适的，可以解释的通的解法 */
    private MyWordBreak myWordBreak;

    /* 第二种解法：动态规划解法—— */
    private MyDpWordBreak myDpWordBreak;

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();

//        String s = "pineapplepenapple";
//        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");

        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        List<String> res = wordBreak.wordBreak4(s, wordDict);
        res.forEach(System.out::println);





//        String s = "catsanddog";
//        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
//        List<String> results = wordBreak.wordBreak3(s,wordDict);
//        results.stream().forEach(System.out::println);
    }





    /* 匹配到原字符串第index个字符时如果成功了，所有成功的列表
     *
     * 此缓存的目的是：如果成功获取到了，以后再次获取该结果时，直接获取，而不用再次匹配
     * */
    Map<Integer, List<List<String>>> cacheMap = new HashMap<>();



    /* 初始游标位置 */
    private static final int CUR_INIT = 0;
    private static final String DELIMITER = " ";

    /* 字典表，key为字典的长度、value为长度为key的所有字符 */
    private Map<Integer,Set<String>> dictMap;
    public List<String> wordBreak(String s, List<String> wordDict) {

        dictMap = wordDict.stream().collect(Collectors.groupingBy(
                String::length,
                TreeMap::new,
                Collectors.toSet()));

        char[] chars = s.toCharArray();

        List<List<String>> wordBreaks = backtrack(chars, CUR_INIT);
        List<String> breakList = wordBreaks.stream().map(item->String.join(DELIMITER,item)).collect(Collectors.toList());

        return breakList;
    }

    /**
     * 第一种方法：记忆搜索，遍历字典表
     * @param chars
     * @param cur
     * @return
     */
    public List<List<String>> backtrack(char[] chars,int cur) {

        if (cacheMap.containsKey(cur)){
            return cacheMap.get(cur);
        }

        List<List<String>> wordBreaks = new LinkedList<>();
        if (cur == chars.length) {
            wordBreaks.add(new LinkedList<>());
            return wordBreaks;
        }

        Iterator<Integer> iterator = dictMap.keySet().iterator();

        while (iterator.hasNext()){
            int len = iterator.next();
            if (cur + len > chars.length){break;} /* 搞了一半，不满足的情况 */
            String str = String.valueOf(chars,cur,len);
            if (!dictMap.get(len).contains(str)){continue;} /* 字典表不包括的情况 */

            for (List<String> item : backtrack(chars,cur + len)){
                List<String> list = new ArrayList<>(1 + item.size()); // new
                list.add(str);
                list.addAll(item);
                wordBreaks.add(list);
            }
        }
        cacheMap.put(cur, wordBreaks);
        return wordBreaks;
    }


    int length = 0;
    public List<String> wordBreak4(String s, List<String> wordDict) {
        // 为了快速判断一个单词是否在单词集合中，需要将它们加入哈希表
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        length = len;
        // 第 1 步：动态规划计算是否有解
        // dp[i] 表示「长度」为 i 的 s 前缀子串可以拆分成 wordDict 中的单词
        // 长度包括 0 ，因此状态数组的长度为 len + 1
        // dp数组，可以匹配到一种情况
        boolean[] dp = new boolean[len + 1];
        // 0 这个值需要被后面的状态值参考，如果一个单词正好在 wordDict 中，dp[0] 设置成 true 是合理的
        dp[len] = true;

        for (int left = len - 1; left >= 0; left--) {
            // 如果单词集合中的单词长度都不长，从后向前遍历是更快的
            for (int right = left + 1; right <= len; right++) {
                // substring 不截取 s[right]，dp[left] 的结果不包含 s[left]
                if (wordSet.contains(s.substring(left, right)) && dp[right]) {

                    dp[left] = true;
                    // 这个 break 很重要，一旦得到 dp[right] = True ，不必再计算下去
                    break;
                }
            }
        }

        // 第 2 步：回溯算法搜索所有符合条件的解
        List<String> res = new ArrayList<>();

        /* dp[0] = true说明该字典可以匹配该串 */
        if (dp[0]) {
            for (boolean b : dp) {
                System.out.print(b+DELIMITER);
            }
            System.out.println("");
            Deque<String> path = new ArrayDeque<>();
            dfs4(s, CUR_INIT, wordSet, dp, path, res);
            return res;
        }
        return res;
    }

    /**
     * s[0:len) 如果可以拆分成 wordSet 中的单词，把递归求解的结果加入 res 中
     *
     * @param s
     * @param cur     长度为 cur 的 s 的前缀子串
     * @param wordSet 单词集合，已经加入哈希表
     * @param dp      预处理得到的 dp 数组
     * @param path    从叶子结点到根结点的路径
     * @param res     保存所有结果的变量
     */
    private void dfs4(String s, int cur, Set<String> wordSet, boolean[] dp, Deque<String> path, List<String> res) {
        if (cur == length) {
            res.add(String.join(DELIMITER,path));
            return;
        }

        // 可以拆分的左边界从 len - 1 依次枚举到 0
        for (int i = cur + 1; i <= length ; i++) {
            String prefix  = s.substring(cur, i);
            if (wordSet.contains(prefix) && dp[i]) {
                path.addLast(prefix);
                dfs4(s, i, wordSet, dp, path, res);
                path.removeLast();
            }
        }
    }
}

