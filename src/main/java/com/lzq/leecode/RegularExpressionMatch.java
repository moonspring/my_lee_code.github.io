package com.lzq.leecode;

/**
 * 10、正则表达式匹配
 */
public class RegularExpressionMatch {

    public static void main(String[] args) {
        isMatch(null,null);
    }

    public static boolean isMatch(String str, String pattern) {

        if (str!=null && pattern!=null){

            char charPoint = '.';
            char charXing = '*';

            char[] charSItems = str.toCharArray();
            char[] charPatternItems = str.toCharArray();

            int iStart = 0,iEnd = charSItems.length;
            int jStart=0, jEnd = charPatternItems.length;
            while (iStart<=iEnd && jStart<=jEnd){

                char one = charSItems[iStart++];
                char two = charPatternItems[jStart++];
                if (one==charPoint || two==charPoint){
                    continue;
                }else if (one==charXing){

                }
            }

        }



        return true;
    }

}
