package com.example.java.Y2024.M04;

import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 2230 - 수 고르기
 * https://www.acmicpc.net/problem/2230
 * 알고리즘 : 투 포인터
 */
public class 수_고르기_2230 {
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
        int ans = arr[N - 1] - arr[0];
        int right = 0;
        for (int i = 0; i < N; i++) {
            while (arr[right] - arr[i] < M && right < N - 1) {
                right++;
            }
            int value = arr[right] - arr[i];
            if(value >= M) ans = Math.min(ans, value);
        }

        bw.write(ans + "");
        bw.flush();
    }
}
