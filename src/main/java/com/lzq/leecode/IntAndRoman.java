package com.lzq.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeeCode
 * 12、数字转罗马数字
 * 13、罗马数字转数字
 */
public class IntAndRoman {

    public static void main(String[] args) {

//        String s = intToRoman(12);
//        System.out.println(s);

        String str = "IV";
        int res = romanToInt2(str);
        System.out.println(res);

    }

    /**
     * 12、数字转罗马数字
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] reps = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<13;i++){
            while(num>=values[i]){
                num-=values[i];
                sb.append(reps[i]);
            }
        }
        return sb.toString();
    }

    public static int romanToInt2(String s){

        char[] items = s.toCharArray();

        int preNum = getValues(items[0]);
        int result = preNum;
        for (int i = 1; i < items.length; i++) {

            int currentNum = getValues(items[i]);
            result += currentNum;
            if (currentNum>preNum){
                result -=2*preNum;
            }else if (currentNum<preNum){
                result +=preNum;
            }
            preNum = currentNum;
        }
        return result;
    }

    private static int getValues(char item){
        switch (item){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }


    /**
     * 13、罗马数字转数字
     * @param s
     * @return
     */
    public static int romanToInt(String s) {

        Map<String,Integer> romanIntMap = new HashMap<String,Integer>(){
            {
                put("M",1000);
                put("CM",900);
                put("D",500);
                put("CD",400);
                put("C",100);
                put("XC",90);
                put("L",50);
                put("XL",40);
                put("X",10);
                put("IX",9);
                put("V",5);
                put("IV",4);
                put("I",1);
            }
        };

        int result = 0;
        while (s.length()>=1){
            String one = s.substring(0,1);

            if (s.length()==1){
                result += romanIntMap.get(one);
                return result;
            }

            String two = s.substring(0,2);
            if (romanIntMap.containsKey(two)){
                s = s.substring(2);
                result +=romanIntMap.get(two);
                continue;
            }
            if (romanIntMap.containsKey(one)){
                s = s.substring(1);
                result +=romanIntMap.get(one);
                continue;
            }

        }

        return result;
    }











}
