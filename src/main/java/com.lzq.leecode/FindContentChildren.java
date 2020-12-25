package com.lzq.leecode;

import java.util.Arrays;

/**
 * LeeCode
 *
 * 455. 分发饼干
 *
 * @author lzq
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int indexG = 0;
        int indexS = 0;

        int res = 0;
        while (indexG<g.length && indexS<s.length){

            /** 分成功 */
            if (s[indexS]>=g[indexG]){
                res++;
                indexG++;
            }
            indexS++;
        }
        return res;
    }
}
