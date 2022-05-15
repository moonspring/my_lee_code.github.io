package com.lzq.leecode2022;
/**
 * 一次编辑
 *
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * @author liuzhengquan
 * @date 2022/05/13 10:07
 **/
public class OneEditAway {

    public static void main(String[] args) {

        String a = "islander";
        String b = "slander";

        oneEditAway(a,b);

    }

    public static boolean oneEditAway(String first, String second) {

        if (first==null && second!=null){
            return false;
        }else if (first!=null && second==null){
            return false;
        }else if (first ==null && second == null){
            return false;
        }

        if (first.length() == second.length() && first.length() == 1){
            return true;
        }

        int diffLength = first.length()-second.length();

        if (Math.abs(diffLength)>1){
            return false;
        }

        if (diffLength == 0){

            int count = 0;
            for (int i = 0; i < second.length();i++) {
                if (second.charAt(i)!=first.charAt(i)){
                    count++;
                }
            }
            return count<2;
        }else {

            if (diffLength<0){
                String tmp = first;
                first = second;
                second = tmp;
            }

            for (int i = 0; i < second.length();i++) {

                if (second.charAt(i)==first.charAt(i)){
                }else if (i+1<first.length() && second.charAt(i)==first.charAt(i+1)){
                }else {
                    return false;
                }
            }
        }

        return true;

    }
}
