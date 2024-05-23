package com.example.java.Y2024.M05;

import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 15317 - 동방 보수
 * https://www.acmicpc.net/problem/15317
 * 알고리즘 : 이분탐색(Parametric Search)
 */
public class 동방보수_15317 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int M = Integer.parseInt(firstInput[1]);
        int X = Integer.parseInt(firstInput[2]);

        int[] cost = new int[N];
        int[] budget = new int[M];
        String[] inputN = br.readLine().split(" ");
        for (int i = 0; i < N; i++) cost[i] = Integer.parseInt(inputN[i]);
        String[] inputM = br.readLine().split(" ");
        for (int i = 0; i < M; i++) budget[i] = Integer.parseInt(inputM[i]);

        Arrays.sort(cost);
        Arrays.sort(budget);

        int l = 0, r = Math.min(N, M), ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (cal(cost, budget, m) <= X) {
                l = m + 1;
                ans = m;
            } else {
                r = m - 1;
            }

        }

        bw.write(ans + "");
        bw.flush();
    }

    private long cal(int[] cost, int[] budget, int assignCount) {
        long needDiff = 0;
        for (int i = 0; i < assignCount; i++) {
            int num = cost[i] - budget[budget.length - assignCount + i];
            needDiff += Math.max(0, num);
        }
        return needDiff;
    }
}
