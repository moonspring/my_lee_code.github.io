package com.lzq.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeeCode
 *
 * 118. 杨辉三角
 *
 * @author lzq
 */
public class PascalTriangle {

    public static void main(String[] args) {

        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> result = pascalTriangle.generate(5);
        System.out.println(result);
    }



    public List<List<Integer>> generate(int numRows) {

        if (numRows == 0){ return Arrays.asList();}
        if (numRows == 1){
            return Arrays.asList(new ArrayList<Integer>(){{
                add(1);
            }});
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> item = new ArrayList<>();
            if(i==0){
                item.add(1);
            }else if (i==1){
                item.add(1);
                item.add(1);
            }else {
                item.add(1);
                for (int k = 0; k < i-1; k++) {
                    List<Integer> tmp = result.get(i-1);
                    item.add(tmp.get(k)+tmp.get(k+1));
                }
                item.add(1);
            }
            result.add(item);

        }
        return result;
    }
}
