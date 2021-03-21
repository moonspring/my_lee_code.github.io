package com.lzq.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeeCode
 *
 * 399. 除法求值
 * 解法三：带权并查集
 *
 * 对于任意两点x,y，假设它们在并查集中具有共同的父亲f，且v[x]/v[f]=a,v[y]/v[f]=b，则v[x]/v[y]=a/b
 * TODO：可以再学习下
 *
 * @author lzq
 */
public class CalcEquation3 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /** 哈希表元素总数*/
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

        /***/
        int[] f = new int[nVars];
        for (int i = 0; i < nVars; i++) {
            f[i] = i;
        }

        double[] w = new double[nVars];
        Arrays.fill(w, 1.0);

        for (int i = 0; i < equations.size(); i++) {
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));
            merge(f, w, va, vb, values[i]);
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

            int fa = findF(f, w, ia);
            int fb = findF(f, w, ib);
            if (fa == fb) {
                result = w[ia] / w[ib];
            }
            res[i] = result;
        }
        return res;
    }

    public void merge(int[] f, double[] w, int x, int y, double val) {
        int fx = findF(f, w, x);
        int fy = findF(f, w, y);
        f[fx] = fy;
        w[fx] = val * w[y] / w[x];
    }

    public int findF(int[] f, double[] w, int x) {
        if (f[x] != x) {
            int father = findF(f, w, f[x]);
            w[x] = w[x] * w[f[x]];
            f[x] = father;
        }
        return f[x];
    }


}
