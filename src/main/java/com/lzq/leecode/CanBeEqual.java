package com.lzq.leecode;

import java.util.Arrays;

public class CanBeEqual {

    public boolean canBeEqual(int[] target, int[] arr) {

        Arrays.sort(target);
        Arrays.sort(arr);
        if (target.length!=arr.length){return false;}
        for (int i = 0; i < target.length; i++) {
            if (target[i]!=arr[i]){
                return false;
            }
        }
        return true;
    }
}
