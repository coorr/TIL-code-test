package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 14465 - 소가 길을 건너간 이유 5
 * https://www.acmicpc.net/problem/14465
 * 알고리즘 : 누적합
 */
public class 소가길을건너간이유5_14465 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int B = Integer.parseInt(input[2]);
        int[] broken = new int[100001];
        for (int i = 0; i < B; i++) {
            broken[Integer.parseInt(br.readLine())]++;
        }

        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (broken[i + 1] > 0) {
                arr[i] += sum;
            } else {
                arr[i] += ++sum;
            }
        }

        int ans = arr[K - 1];
        for (int i = 1; i < N - K + 1; i++) {
            int x = arr[i + K - 1] - arr[i - 1];
            ans = Math.max(ans, x);
        }

        bw.write(K - ans + "");
        bw.flush();
    }
}
