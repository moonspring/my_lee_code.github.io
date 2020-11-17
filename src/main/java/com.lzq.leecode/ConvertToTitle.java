package com.lzq.leecode;

/**
 * LeeCode
 *
 * 168. Excel表列名称
 */
public class ConvertToTitle {

    public static void main(String[] args) {
        String s = convertToTitle(52);
        System.out.println(s);
    }


    public static String convertToTitle(int n) {

        String s = "";
        int k = n;
        while(k>0){
            k--;
            int mod = k%26;
            s += (char)('A'+mod);
            k = k/26;
        }

        char[] ch =  s.toCharArray();

        int i = 0;
        int j = ch.length - 1;
        while (i<j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }

        return String.valueOf(ch);
    }
}
