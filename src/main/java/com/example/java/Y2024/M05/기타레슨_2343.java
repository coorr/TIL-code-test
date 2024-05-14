package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 2343 - 기타 레슨
 * https://www.acmicpc.net/problem/2343
 * 알고리즘 : 이분탐색
 */
public class 기타레슨_2343 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int M = Integer.parseInt(firstInput[1]);
        String[] secondInput = br.readLine().split(" ");
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(secondInput[i]);
            sum += arr[i];
        }
        int l = 0, r = sum, ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(arr, m, M)) {
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
        int number = 0;
        int tempCount = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > m) return false;
            if (number + arr[i] > m) {
                number = arr[i];
                tempCount++;
            } else {
                number += arr[i];
            }
        }

        if (tempCount <= count) {
            return true;
        }
        return false;
    }
}
