package com.example.java.Y2024.M06;

import java.io.*;

/**
 * [BOJ] 10971 - 외판원 순회 2
 * https://www.acmicpc.net/problem/10971
 * 알고리즘 : 재귀
 */
public class 외판원순회2_10971 {
    static int N;
    static int[][] W;
    static int ans = Integer.MAX_VALUE;
    static boolean[] visited;

    private void solve(int start, int node, int sum, int count) {
        if (count == N && start == node) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[node][i] != 0) {
                visited[i] = true;
                solve(start, i, sum + W[node][i], count + 1);
                visited[i] = false;
            }
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(str[j]);
            }
        }
        solve(0, 0, 0, 0);

        bw.write(ans + "");
        bw.flush();
    }
}
