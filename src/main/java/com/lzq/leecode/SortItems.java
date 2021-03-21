package com.lzq.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeeCode
 * <p>
 * 1203. 项目管理
 *
 * @author lzq
 */
public class SortItems {


    public static void main(String[] args) {

        String res = plusEle();
        System.out.println("res="+res);
    }

    public static String plusEle(){
        int i = 0;
        try {
            System.out.println(++i);
            return "a"+(++i);
        }catch (Exception e){
            System.err.println(++i);
            return "b"+(++i);
        }finally {
            return "c"+(++i);
        }
    }






    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        List<List<Integer>> groupItem = new ArrayList<>();
        for (int i = 0; i < n + m; ++i) {
            groupItem.add(new ArrayList<>());
        }

        // 组间和组内依赖图
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < n + m; ++i) {
            groupGraph.add(new ArrayList<>());
        }
        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            itemGraph.add(new ArrayList<>());
        }

        // 组间和组内入度数组
        int[] groupDegree = new int[n + m];
        int[] itemDegree = new int[n];

        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < n + m; ++i) {
            id.add(i);
        }

        int leftId = m;
        // 给未分配的 item 分配一个 groupId
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = leftId;
                leftId += 1;
            }
            groupItem.get(group[i]).add(i);
        }
        // 依赖关系建图
        for (int i = 0; i < n; ++i) {
            int curGroupId = group[i];
            for (int item : beforeItems.get(i)) {
                int beforeGroupId = group[item];
                if (beforeGroupId == curGroupId) {
                    itemDegree[i] += 1;
                    itemGraph.get(item).add(i);
                } else {
                    groupDegree[curGroupId] += 1;
                    groupGraph.get(beforeGroupId).add(curGroupId);
                }
            }
        }

        // 组间拓扑关系排序
        List<Integer> groupTopSort = topSort(groupDegree, groupGraph, id);
        if (groupTopSort.size() == 0) {
            return new int[0];
        }
        int[] ans = new int[n];
        int index = 0;
        // 组内拓扑关系排序
        for (int curGroupId : groupTopSort) {
            int size = groupItem.get(curGroupId).size();
            if (size == 0) {
                continue;
            }
            List<Integer> res = topSort(itemDegree, itemGraph, groupItem.get(curGroupId));
            if (res.size() == 0) {
                return new int[0];
            }
            for (int item : res) {
                ans[index++] = item;
            }
        }
        return ans;
    }

    /**
     * 拓扑排序函数
     *
     * @param deg 点的入度数组为deg
     * @param graph 点的连边关系为graph，graph[i] 表示点i连出点组成的集合，如果不存在冲突，返回拓扑排序后的数组，否则返回一个空数组
     * @param items 当前待拓扑排序的点集为items
     * @return
     */
    public List<Integer> topSort(int[] deg, List<List<Integer>> graph, List<Integer> items) {

        Queue<Integer> queue = new LinkedList<>();
        for (int item : items) {
            if (deg[item] == 0) {
                queue.offer(item);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            res.add(u);
            for (int v : graph.get(u)) {
                if (--deg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return res.size() == items.size() ? res : new ArrayList<>();
    }


}
