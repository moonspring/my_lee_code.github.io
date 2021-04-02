package com.lzq.interview;

/**
 * @author adam
 */
public class BigNumberPlus {

    public static void main(String[] args) {

        String a = "3243253663";
        String b = "320593209532";
        String res = bigNumberPlus(a,b);
        System.err.println(res);
    }


    public static String bigNumberPlus(String a,String b){

        int bigThan = 0;
        if (a.length()>b.length()){
            bigThan = a.length()-b.length();
            b = equalLong(b,bigThan);
        }else if (a.length()<b.length()){
            bigThan = b.length()-a.length();
            a = equalLong(a,bigThan);
        }

        String res = "";

        int step = 0;
        int va;
        for (int i = a.length()-1; i >=0; i--) {
            va =Integer.valueOf(String.valueOf(a.charAt(i)))+Integer.valueOf(String.valueOf(b.charAt(i)));
            if (va+step>=10){
                res = (va + step - 10) + res;
                step = 1;
            }else {
                res = (va + step) + res;
                step = 0;
            }
        }
        if (step!=0){
            res = step+ res;
        }
        return res;
        
    }
    
    private static String equalLong(String str,int count){
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("0");
        }
        sb.append(str);
        return sb.toString();
    }
    
}
