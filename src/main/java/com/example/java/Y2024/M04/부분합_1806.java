package com.example.java.Y2024.M04;

import java.io.*;

/**
 * [BOJ] 1806 - 부분합
 * https://www.acmicpc.net/problem/1806
 * 알고리즘 : 투 포인터 사용
 */
public class 부분합_1806 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLineInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstLineInput[0]);
        int M = Integer.parseInt(firstLineInput[1]);
        int[] arr = new int[N];
        String[] secondLineInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(secondLineInput[i]);
        }

        int ans = Integer.MAX_VALUE;
        int right = 0;
        long sum = arr[0];
        for (int i = 0; i < N; i++) {
            while (sum < M && right < N - 1) {
                sum += arr[++right];
            }
            if(sum >= M) ans = Math.min(right - i + 1, ans);
            sum -= arr[i];
        }
        ans = ans == Integer.MAX_VALUE ? 0 : ans;
        bw.write(ans + "");
        bw.flush();
    }
}
