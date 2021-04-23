package com.lzq.leecode;

/**
 * LeeCode
 * 1678. 设计 Goal 解析器
 * 方法二
 * @author adam
 */
public class Interpret2 {

    public static void main(String[] args) {
        String command = "G()(al)";
        interpret(command);
    }


    public static String interpret(String command) {

        char[] charRes = new char[command.length()];
        int indexRes = 0;
        int indexComm = 0;

        while (indexComm < command.length()){
            switch (command.charAt(indexComm)){
                case 'G':
                    charRes[indexRes++] = 'G';
                    indexComm++;
                    break;
                case '(':
                    if(command.charAt(indexComm+1)==')'){
                        charRes[indexRes++] = 'o';
                        indexComm+=2;
                        break;
                    }else if (command.charAt(indexComm+1)=='a'){
                        charRes[indexRes++] = 'a';
                        charRes[indexRes++] = 'l';
                        indexComm+=4;
                        break;
                    }
                    break;
            }
        }

        return new String(charRes,0,indexRes);
    }
}
