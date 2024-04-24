package com.example.java.Y2024.M04;

import java.io.*;

/**
 * [BOJ] 2805 - 나무 자르기
 * https://www.acmicpc.net/problem/2805
 */
public class 나무자르기_2805 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLineInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstLineInput[0]);
        int M = Integer.parseInt(firstLineInput[1]);
        int[] arr = new int[N];
        String[] twoLineInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(twoLineInput[i]);
        }
        int ans = getMaxHeight(arr, M);
        bw.write(ans + "");

        bw.flush();
    }

    private int getMaxHeight(int[] arr, int height) {
        int l = 0, r = 1000000000, ans = 0;

        while (l <= r) {
            int m = (l + r) / 2;
            if (getSumCutHeight(arr, m) >= height) {
                l = m + 1;
                ans = m;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    private long getSumCutHeight(int[] arr, int height) {
        long sum = 0;
        for (int j : arr) {
            if (height < j) {
                sum += j - height;
            }
        }
        return sum;
    }
}
