package com.lzq.leecode;

/**
 * LeeCode
 * 1281. 整数的各位积和之差
 *
 * @author adam
 */
public class SubtractProductAndSum {

    public static void main(String[] args) {

        System.out.println(SubtractProductAndSum.subtractProductAndSum(234));

    }


    public static int subtractProductAndSum(int n) {
        int step = 10;
        int mul = 1,add = 0;
        int digit;
        do {
            digit=n%step;
            n /=step;
            mul*=digit;
            add+=digit;
        }while (n>0);
        return mul-add;
    }

}
