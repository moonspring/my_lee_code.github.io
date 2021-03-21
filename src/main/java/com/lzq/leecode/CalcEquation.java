package com.lzq.leecode;

import java.util.*;

/**
 * LeeCode
 *
 * 399. 除法求值
 * 解法一：广度优先搜索
 *  将整个问题建模成一张图：给定图中的一些点（变量），以及某些边的权值（两个变量的比值），试对任意两点（两个变量）求出其路径长（两个变量的比值）。
 *
 * 因此，我们首先需要遍历 equations 数组，找出其中所有不同的字符串，并通过哈希表将每个不同的字符串映射成整数。
 *
 * 在构建完图之后，对于任何一个查询，就可以从起点出发，通过广度优先搜索的方式，不断更新起点与当前点之间的路径长度，直到搜索到终点为止
 *
 *  TODO：可以再学习下
 * @author lzq
 */
public class CalcEquation {

    public static void main(String[] args) {

        List<List<String>> equations = Arrays.asList(Arrays.asList("a","b"),Arrays.asList("b","c"));
        double[] values = {2.0,3.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a","c")
                ,Arrays.asList("b","a")
                ,Arrays.asList("a","a")
                ,Arrays.asList("x","x"));

        CalcEquation calcEquation = new CalcEquation();

        calcEquation.calcEquation(equations,values,queries);

    }


    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

        int nVars = 0;
        Map<String,Integer> variables = new HashMap<>(equations.size());
        for (List<String> item:equations) {
            if (!variables.containsKey(item.get(0))){
                variables.put(item.get(0),nVars++);
            }
            if (!variables.containsKey(item.get(1))){
                variables.put(item.get(1),nVars++);
            }
        }

        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[nVars];
        for (int i = 0; i < nVars; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < equations.size(); i++) {
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));

            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }


        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            List<String> query = queries.get(i);
            double result = -1.0;

            /** 无解的情况 */
            if (!variables.containsKey(query.get(0)) || !variables.containsKey(query.get(1))){
                res[i] = result;
                continue;
            }

            /** 有解的情况 */
            int ia = variables.get(query.get(0));
            int ib = variables.get(query.get(1));

            if (ia == ib) {
                result = 1.0;
                res[i] = result;
                continue;
            }

            Queue<Integer> points = new LinkedList<>();
            points.offer(ia);

            double[] ratios = new double[nVars];
            Arrays.fill(ratios, -1.0);
            ratios[ia] = 1.0;

            while (!points.isEmpty() && ratios[ib] < 0) {
                int x = points.poll();
                for (Pair pair : edges[x]) {
                    int y = pair.index;
                    double val = pair.value;
                    if (ratios[y] < 0) {
                        ratios[y] = ratios[x] * val;
                        points.offer(y);
                    }
                }
            }
            result = ratios[ib];
            res[i] = result;
        }
        return res;

    }

    static class Pair {
        int index;
        double value;

        Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }

}
