package com.lzq.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeeCode
 *
 * 205. 同构字符串
 *
 * @author lzq
 */
public class IsIsomorphic {


    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        Map<Character, Character> s2t = new HashMap<>(len);
        Map<Character, Character> t2s = new HashMap<>(len);
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i);
            char y = t.charAt(i);

            boolean flag0 = s2t.containsKey(x) && s2t.get(x) != y;
            boolean flag1 = t2s.containsKey(y) && t2s.get(y) != x;

            if (flag0 || flag1) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }


//    public boolean isIsomorphic(String s, String t) {
//
//        char[] charS = s.toCharArray();
//        int[] intCountS = new int[s.length()];
//        char[] charT = t.toCharArray();
//        int[] intCountT = new int[t.length()];
//
//        for (int i = 0; i < charS.length; i++) {
//            intCountS[i] = charS[i]-'a';
//        }
//        for (int i = 0; i < charT.length; i++) {
//            intCountT[i] = charT[i]-'a';
//        }
//
//        for
//
//        return false;
//    }

}
