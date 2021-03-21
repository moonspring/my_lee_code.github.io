package com.lzq.leecode;

import java.util.*;

/**
 * LeeCode
 * <p>
 * 1202. 交换字符串中的元素
 *
 * @author lzq
 */
public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DisjointSetUnion dsu = new DisjointSetUnion(s.length());
        for (List<Integer> pair : pairs) {
            dsu.unionSet(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
        for (int i = 0; i < s.length(); i++) {
            int parent = dsu.find(i);
            if (!map.containsKey(parent)) {
                map.put(parent, new ArrayList<Character>());
            }
            map.get(parent).add(s.charAt(i));
        }
        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            Collections.sort(entry.getValue(), (c1, c2) -> c2 - c1);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            int x = dsu.find(i);
            List<Character> list = map.get(x);
            sb.append(list.remove(list.size() - 1));
        }
        return sb.toString();
    }

    static class DisjointSetUnion {
        int[] f;
        int[] rank;
        int n;

        public DisjointSetUnion(int n) {
            this.n = n;
            rank = new int[n];
            Arrays.fill(rank, 1);
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        public int find(int x) {
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        public void unionSet(int x, int y) {
            int fx = find(x);
            int fy = find(y);

            if (fx == fy) {
                return;
            }
            if (rank[fx] < rank[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            rank[fx] += rank[fy];
            f[fy] = fx;
        }
    }
}


