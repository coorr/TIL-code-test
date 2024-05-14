package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 2792 - 보석상자
 * https://www.acmicpc.net/problem/2792
 * 알고리즘 : 이분탐색
 */
public class 보석상자_2792 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int M = Integer.parseInt(firstInput[1]);
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int l = 1, r = 1000000000, ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(arr, m, N)) {
                r = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }

        bw.write(ans + "");
        bw.flush();
    }

    private boolean isPossible(int[] arr, int m, int count) {
        int tempCount = 0;
        for (int i = 0; i < arr.length; i++) {
            tempCount += arr[i] / m;
            int reminder = arr[i] % m;
            if (reminder > 0) {
                tempCount += 1;
            }
        }

        if (tempCount <= count) {
            return true;
        }
        return false;
    }
}
