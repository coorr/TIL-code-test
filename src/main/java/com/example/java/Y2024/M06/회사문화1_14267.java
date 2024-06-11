package com.example.java.Y2024.M06;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * [BOJ] 14267 - 회사 문화 1
 * https://www.acmicpc.net/problem/14267
 * 알고리즘 : 재귀
 */
public class 회사문화1_14267 {
    static int[] like;
    static List<Integer>[] tree;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        int n = Integer.parseInt(firstInput[0]);
        int m = Integer.parseInt(firstInput[1]);
        like = new int[n + 1];
        tree = new ArrayList[n + 1];
        String[] secondInput = br.readLine().split(" ");
        for (int i = 1; i < n + 1; i++) {
            int employee = Integer.parseInt(secondInput[i - 1]);
            tree[i] = new ArrayList<>();

            if (employee != -1) {
                tree[employee].add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            String[] thirdInput = br.readLine().split(" ");
            int employee = Integer.parseInt(thirdInput[0]);
            int point = Integer.parseInt(thirdInput[1]);
            like[employee] += point;
        }

        // 1번째 상사부터 차례대로 칭찬의 횟수를 구하기
        next(1);
        for (int i = 1; i < n + 1; i++) {
            bw.write(like[i] + " ");
        }
        bw.flush();
    }

    private void next(int node) {
        for (int child : tree[node]) {
            like[child] += like[node];
            next(child);
        }
    }
}
