package com.lzq;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    private TestMain(){}
    
    public static class Singleton{
        private static TestMain instance = new TestMain();
    }

    public static TestMain getInstance(){
        return Singleton.instance;
    }







    public List<int[]> findItem(int[] array, int Y){

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {

            for (int j = i+1; j < array.length; j++) {
                if (array[i]+array[j]==Y){
                    int[] item = {array[i],array[j]};
                    res.add(item);
                    break;
                }else if (array[i]+array[j]>Y){
                    break;
                }
            }
        }
        return res;
    }

}
