package com.lzq.leecode;

/**
 * LeeCode
 * 1678. 设计 Goal 解析器
 * 方法一
 * @author adam
 */
public class Interpret {

    public String interpret(String command) {
        return command.replaceAll("\\(al\\)","al").replaceAll("\\(\\)","o");
    }
}
