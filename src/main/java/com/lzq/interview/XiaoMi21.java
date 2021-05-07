package com.lzq.interview;

import java.util.Arrays;

/**
 *
 * 给一个字符串,判断是否为ip地址
 * @author adam
 */
public class XiaoMi21 {

    public boolean isIp(String str){
        if (str==null || "".equals(str)){
            return false;
        }
        long count = Arrays.stream(str.split("//."))
                .map(item->Integer.valueOf(item))
                .filter(item->item>0 && item<255)
                .count();
        return count==4;
    }

}
