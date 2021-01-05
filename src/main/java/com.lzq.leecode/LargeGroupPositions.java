package com.lzq.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeeCode
 *
 * 830. 较大分组的位置
 * @author lzq
 */
public class LargeGroupPositions {

    public static void main(String[] args) {
        LargeGroupPositions a = new LargeGroupPositions();
        a.largeGroupPositions("aa");
    }


    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int start;
        int cur = 0;
        while (cur+1<s.length()){
            start = cur;
            while (cur+1<s.length() && s.charAt(cur)==s.charAt(cur+1)){cur++;}
            if (cur-start-2>=0){
                List<Integer> ls = Arrays.asList(start,cur);
                res.add(ls);
            }
            cur++;
        }
        return res;
    }
}
