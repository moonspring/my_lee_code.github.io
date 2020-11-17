package com.lzq.leecode;


import java.util.*;
import java.util.stream.Collectors;

/**
 * LeeCode
 * 140 单词拆分
 * 记忆化搜索
 */
public class MyWordBreak {


    public static void main(String[] args) {

        MyWordBreak wordBreak = new MyWordBreak();

        String s = "catsanddog";

        System.out.println("原字符串---------------");
        System.out.println("s="+s);
        System.out.println("原字符串长度---------------");
        System.out.println("s.length()="+s.length());
        System.out.println("---------------");

        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println("字典---------------");
        wordDict.forEach(System.out::println);

        List<String> res = wordBreak.wordBreak(s, wordDict);
        System.out.println("结果---------------");
        res.forEach(System.out::println);
    }




    /*
     * */
    Map<Integer, List<List<String>>> cacheMap = new HashMap<>();

    /* 初始游标位置 */
    private static final int CUR_INIT = 0;

    /* 空格符 */
    private static final String DELIMITER = " ";

    /* 字典表 */
    private Set<String> wordDictSet;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordDictSet = new HashSet<>(wordDict);

        char[] chars = s.toCharArray();
        List<List<String>> wordBreaks = brackTrack(chars,CUR_INIT);
//        System.out.println("cacheMap---------------");
//        cacheMap.entrySet().forEach(System.out::println);
        List<String> breakList = wordBreaks.stream().map(item->String.join(DELIMITER,item)).collect(Collectors.toList());
        return breakList;
    }

    int count = 0;

    /**
     *
     * @param chars 原字符串
     * @param cur 移动的游标位置
     * @return 结果集 匹配成功的字符串
     */
    public List<List<String>> brackTrack(char[] chars,int cur){

        int length = chars.length;
        if(cacheMap.containsKey(cur)){
            System.err.println("cacheMap缓存了该值value="+cacheMap.get(cur)+";cacheMap="+cacheMap);
            return cacheMap.get(cur);
        }

        /* 返回结果：跟自电表完全匹配的列表 */
        List<List<String>> wordBreaks = new LinkedList<>();
        if(cur == length){
            wordBreaks.add(new LinkedList<>());
        }

        for(int i = cur+1;i<=length;i++){

            String word = String.valueOf(chars,cur,i-cur);

            System.out.println("所有word="+word+";i="+i+";cur="+cur);
            if(wordDictSet.contains(word)){

                System.err.println("第"+(++count)+"层递归:i="+i+";cur="+cur+";匹配的word="+word);
                List<List<String>> nextWordBreaks = brackTrack(chars,i);

                for (List<String> nextWordBreak : nextWordBreaks) {
                    LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
                    wordBreak.offerFirst(word);

                    wordBreaks.add(wordBreak);
                    System.err.println("i="+i+";cur="+cur+";匹配的word="+word);
                    wordBreaks.stream().forEach(System.err::println);
                }
            }
        }
        cacheMap.put(cur,wordBreaks);
//        return cacheMap.get(cur);
        return wordBreaks;
    }
}
