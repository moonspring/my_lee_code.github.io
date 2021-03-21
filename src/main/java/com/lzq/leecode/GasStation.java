package com.lzq.leecode;


/**
 * LeeCode
 *
 * 134. 加油站
 * 解法一 ：遍历寻找
 */
public class GasStation {

    public static void main(String[] args) {

//        GasStation gasStation = new GasStation();
        GasStation2 gasStation = new GasStation2();

        int[] gas = {5,8,2,8};
        int[] cost = {6,5,6,6};

        int result = gasStation.canCompleteCircuit(gas,cost);
        System.out.println(result);

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int intStartIndex;
        for (int i = 0; i < len; i++) {
            //消耗比加的油多，则选下一个点
            if (cost[i]>gas[i]){
                continue;
            }
            intStartIndex = i;
            int start = intStartIndex;
            int left = gas[start];
            int itemLength = 0;
            while (itemLength<len){
                left = left - cost[start];
                if (left<0){ break; }
                if (start+1 == len){
                    if (!(itemLength==len -1)){
                        left = left + gas[0];
                    }
                    start = -1;
                }else {
                    if (!(itemLength==len - 1)){
                        left = left + gas[start+1];
                    }
                }
                start++;
                itemLength++;
            }
            if (itemLength == len){
                return intStartIndex;
            }
        }
        return -1;
    }
}
