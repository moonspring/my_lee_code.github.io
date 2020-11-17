package com.lzq.leecode;

/**
 * 9、判断是否为回文子串
 */
public class IsPalindrome {

    public static void main(String[] args) {
        isPalindrome(121);
    }

    public static boolean isPalindrome(int x){

        String str = String.valueOf(x);

        if (str==null){ return false;}
        if (str.length()==1){return true;}

        char[] charItems = str.toCharArray();

        char charFirst = charItems[0];

        if (charFirst == '+' || charFirst == '-') {
            return false;
        }

        int start = 0;
        int end = charItems.length-1;
        while (start<=end){
            if (charItems[start++]!=charItems[end--]){return false;}
        }
        return true;
    }


}
