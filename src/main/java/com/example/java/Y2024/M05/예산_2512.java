package com.example.java.Y2024.M05;

import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 2512 - 예산
 * https://www.acmicpc.net/problem/2512
 * 알고리즘 : 이분탐색
 */
public class 예산_2512 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);
        Arrays.sort(arr);

        int ans = arr[arr.length - 1];
        int l = 0;
        int r = arr[arr.length - 1];
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(arr, m, M)) {
                l = m + 1;
                ans = m;
            } else {
                r = m - 1;
            }
        }

        bw.write(ans + "");
        bw.flush();
    }

    private boolean isPossible(int[] arr, int m, int max) {
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            if (m >= arr[i]) {
                number += arr[i];
            } else {
                number += m;
            }
        }

        if (number > max) {
            return false;
        }
        return true;
    }
}
