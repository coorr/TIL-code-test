package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 15961 - 회전 초밥
 * https://www.acmicpc.net/problem/15961
 * 알고리즘 : 투포인터(sliding_window)
 */
public class 회전초밥_15961 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int D = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        int C = Integer.parseInt(input[3]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        int ans = 0;
        int[] frequency = new int[D + 1];
        int count = 0;

        for (int i = 0; i < K - 1; i++) {
            if (frequency[arr[i]]++ == 0) {
                count++;
            }
        }
        for (int i = 0; i < N; i++) {
            if (frequency[arr[(i + K - 1) % N]]++ == 0) {
                count++;
            }
            ans = Math.max(ans, count + (frequency[C] == 0 ? 1 : 0));
            if (--frequency[arr[i]] == 0) {
                count--;
            }
        }
        bw.write(ans + "");
        bw.flush();
    }
}
