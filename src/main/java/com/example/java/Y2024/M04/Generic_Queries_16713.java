package com.example.java.Y2024.M04;

import java.io.*;

/**
 * [BOJ] 16713 - Generic Queries
 * https://www.acmicpc.net/problem/16713
 */
public class Generic_Queries_16713 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] oneInput = br.readLine().split(" ");
        int N = Integer.parseInt(oneInput[0]);
        int Q = Integer.parseInt(oneInput[1]);
        int[] nums = new int[N + 1];
        int[] accumulate = new int[N + 1];

        String[] twoInput = br.readLine().split(" ");
        for (int i = 1; i < N + 1; i++) {
            nums[i] = Integer.parseInt(twoInput[i - 1]);
        }

        // 누적 XOR 배열 구하기
        for (int i = 1; i < N + 1; i++) {
            accumulate[i] = accumulate[i - 1] ^ nums[i];
        }

        // 누적 XOR 활용해서 마지막 구간 XOR 값 구하기
        int answer = 0;
        for (int i = 0; i < Q; i++) {
            String[] threeInput = br.readLine().split(" ");
            int a = Integer.parseInt(threeInput[0]);
            int b = Integer.parseInt(threeInput[1]);

            answer = accumulate[a - 1] ^ accumulate[b];
        }

        bw.write(answer + "");
        bw.flush();
    }
}
