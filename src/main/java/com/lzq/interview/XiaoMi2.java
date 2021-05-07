package com.lzq.interview;

/**
 *
 * 给一个字符串,判断是否为ip地址
 * @author adam
 */
public class XiaoMi2 {

    public boolean isIp(String str){
        if (str==null || "".equals(str)){
            return false;
        }
        String[] items = str.split("//.");
        if (items.length!=4){
            return false;
        }
        for (String item:items) {
            if (Integer.valueOf(item)<0 || Integer.valueOf(item)>255){
                return false;
            }
        }
        return true;
    }

}
