package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 13144 - List of Unique Numbers
 * https://www.acmicpc.net/problem/13144
 * 알고리즘 : 투 포인터
 */
public class ListofUniqueNumbers_13144 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        boolean[] appeared = new boolean[100001];
        long ansCount = 0;
        int nextIndex = 0;
        for (int i = 0; i < N; i++) {
            while (nextIndex < N) {
                if(appeared[arr[nextIndex]]) break;
                appeared[arr[nextIndex++]] = true;
            }
            ansCount += nextIndex - i;
            appeared[arr[i]] = false;
        }

        bw.write(ansCount + "");
        bw.flush();
    }
}
