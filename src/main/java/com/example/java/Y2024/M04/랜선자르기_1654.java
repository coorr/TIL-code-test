package com.example.java.Y2024.M04;

import java.io.*;

/**
 * [BOJ] 1654 - 랜선 자르기
 * https://www.acmicpc.net/problem/1654
 */
public class 랜선자르기_1654 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLineInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstLineInput[0]);
        int M = Integer.parseInt(firstLineInput[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long l = 0, r = (1L << 31) - 1, ans = 0;
        while (l <= r) {
            long m = (l + r) / 2;
            long count = getCountLanCable(arr, m);
            if (count >= M) {
                l = m + 1;
                ans = m;
            } else {
                r = m - 1;
            }
        }

        bw.write(ans + "");
        bw.flush();
    }

    private long getCountLanCable(int[] arr, long currentLanCable) {
        long count = 0;
        for (int i : arr) {
            count += i / currentLanCable;
        }
        return count;
    }
}
