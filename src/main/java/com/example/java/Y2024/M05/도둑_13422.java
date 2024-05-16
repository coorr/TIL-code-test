package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 13422 - 도둑
 * https://www.acmicpc.net/problem/13422
 * 알고리즘 : 투 포인터
 */
public class 도둑_13422 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int number = 0;
            int count = 0;
            String[] firstInput = br.readLine().split(" ");
            int N = Integer.parseInt(firstInput[0]);
            int M = Integer.parseInt(firstInput[1]);
            int K = Integer.parseInt(firstInput[2]);

            String[] secondInput = br.readLine().split(" ");
            int[] arr = new int[N + M - 1];
            for (int j = 0; j < N; j++) arr[j] = Integer.parseInt(secondInput[j]);
            for (int k = 0; k < M - 1; k++) {
                arr[N + k] = arr[k];
            }
            for (int j = 0; j < M; j++) number += arr[j];
            if(K > number) count++;
            if (N != M) {
                for (int j = 1; j <= arr.length - M; j++) {
                    number -= arr[j - 1];
                    number += arr[j + M - 1];

                    if (K > number) count++;
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
    }
}
