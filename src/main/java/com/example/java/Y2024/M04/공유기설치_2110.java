package com.example.java.Y2024.M04;

import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 2110 - 공유기 설치
 * https://www.acmicpc.net/problem/2110
 */
public class 공유기설치_2110 {
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
        Arrays.sort(arr);
        int l = 0, r = 1000000000, ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(arr,m,M)) {
                l = m + 1;
                ans = m;
            } else {
                r = m - 1;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private boolean isPossible(int[] homes, int distance, int maxCount) {
        int count = 1;
        int home = homes[0];
        for (int i = 1; i < homes.length; i++) {
            if (homes[i] - home >= distance) {
                count++;
                home = homes[i];
                if (count == maxCount) return true;
            }
        }
        return false;
    }
}
