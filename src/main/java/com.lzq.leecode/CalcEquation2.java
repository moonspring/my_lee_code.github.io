package com.lzq.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeeCode
 * <p>
 * 399. 除法求值
 * 解法二：Floyd 算法 对图预处理。
 *  TODO：这种情况好理解
 *
 * @author lzq
 */
public class CalcEquation2 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int nVars = 0;
        /** 构造哈希表 */
        Map<String,Integer> variables = new HashMap<>(equations.size());
        for (List<String> item:equations) {
            if (!variables.containsKey(item.get(0))){
                variables.put(item.get(0),nVars++);
            }
            if (!variables.containsKey(item.get(1))){
                variables.put(item.get(1),nVars++);
            }
        }

        /** 构造图 */
        double[][] graph = new double[nVars][nVars];
        for (int i = 0; i < nVars; i++) {
            Arrays.fill(graph[i], -1.0);
        }
        /** a/b  b/a */
        for (int i = 0; i < equations.size(); i++) {
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));
            graph[va][vb] = values[i];
            graph[vb][va] = 1.0 / values[i];
        }
        /** a/b b/c */
        for (int k = 0; k < nVars; k++) {
            for (int i = 0; i < nVars; i++) {
                for (int j = 0; j < nVars; j++) {
                    if (graph[i][k] > 0 && graph[k][j] > 0) {
                        graph[i][j] = graph[i][k] * graph[k][j];
                    }
                }
            }
        }

        double[] res = new double[queries.size()];

        /** 遍历所有问题条件*/
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

            if (graph[ia][ib] > 0) {
                result = graph[ia][ib];
            }
            res[i] = result;
        }
        return res;
    }
}
