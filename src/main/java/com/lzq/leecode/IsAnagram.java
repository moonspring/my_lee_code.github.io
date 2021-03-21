package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 242. 有效的字母异位词
 */
public class IsAnagram {
    

    public boolean isAnagram(String s, String t) {

        char[] charT = t.toCharArray();
        char[] charS = s.toCharArray();

        if (charT.length != charS.length) {
            return false;
        }

        Arrays.sort(charS);
        Arrays.sort(charT);

        return Arrays.equals(charS,charT);


    }

}
