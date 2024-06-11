package com.example.java.Y2024.M06;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * [BOJ] 15681 - 트리와 쿼리
 * https://www.acmicpc.net/problem/15681
 * 알고리즘 : 재귀
 */
public class 트리와쿼리_15681 {
    static int[] query;
    static List<Integer>[] tree;
    static boolean[] check;
    static int[] sum;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int R = Integer.parseInt(firstInput[1]);
        int Q = Integer.parseInt(firstInput[2]);
        check = new boolean[N + 1];
        query = new int[N + 1];
        tree = new ArrayList[N + 1];
        sum = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            String[] secondInput = br.readLine().split(" ");
            int node1 = Integer.parseInt(secondInput[0]);
            int node2 = Integer.parseInt(secondInput[1]);
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        // 루트 노드부터 시작해서 각 노드마다 자식 노드의 갯수를 저장
        getSum(R);
        for (int i = 0; i < Q; i++) {
            int u = Integer.parseInt(br.readLine());
            bw.write(sum[u] + "\n");
        }
        bw.flush();
    }

    int getSum(int node) {
        if(sum[node] != 0) return sum[node];
        check[node] = true;
        int result = 1;

        for (int child : tree[node]) {
            if (!check[child]) {
                result += getSum(child);
            }
        }

        sum[node] = result;
        return result;
    }
}
