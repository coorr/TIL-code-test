package com.example.java.Y2024.M04;

import java.io.*;

/**
 * [BOJ] 2003 - 수들의 합 2
 * https://www.acmicpc.net/problem/2003
 * 알고리즘 : 투 포인터
 */
public class 수들의합2_2003 {
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

        int count = 0;
        int right = 0;
        int sum = arr[0];
        for (int i = 0; i < N; i++) {
            while (sum < M && right < N - 1) {
                sum += arr[++right];
            }
            if(sum == M) count++;
            sum -= arr[i];
        }
        bw.write(count + "");
        bw.flush();
    }
}
