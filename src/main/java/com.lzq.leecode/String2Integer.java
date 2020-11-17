package com.lzq.leecode;

/**
 * 8、字符串转Integer
 */
public class String2Integer {

    private static final int max = Integer.MAX_VALUE / 10;

    /* 0 1 2 3 4 5 6 7 8 9 */
    private static final int maxLeft = Integer.MAX_VALUE % 10;

    private static final int min = Integer.MIN_VALUE / 10;
    private static final int minLeft = Integer.MIN_VALUE % 10;


    public static void main(String[] args) {
        String2Integer solution = new String2Integer();

        String str = "  -21JD47483646 djof";
        int res = solution.myAtoi(str);
        System.out.println(res);


//        int  n = 90;
//        char ch = (char)(n+'0');
//
//        System.out.println(ch);
    }

    public int myAtoi(String str) {

        /* 字符串长度 */
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;

        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > max || (res == max && (currChar - '0') > maxLeft)) {
                return Integer.MAX_VALUE;
            }
            if (res < min || (res == min && (currChar - '0') > -(minLeft))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            // '0'的ASCII码是48，'1'的是49，这么一减就从就可以得到真正的整数值
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }
}
