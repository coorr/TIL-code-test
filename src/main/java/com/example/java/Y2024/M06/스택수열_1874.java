package com.example.java.Y2024.M06;

import java.io.*;

/**
 * [BOJ] 1874 - 스택 수열
 * https://www.acmicpc.net/problem/1874
 * 알고리즘 : stack
 */
public class 스택수열_1874 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] stacks = new int[N];
        int topIndex = -1;
        int nextNumber = 1;
        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            while (nextNumber <= x) {
                sb.append("+\n");
                stacks[++topIndex] = nextNumber++;
            }

            if (topIndex < 0 || stacks[topIndex] != x) {
                sb.setLength(0);
                sb.append("NO\n");
                break;
            }
            sb.append("-\n");
            topIndex--;
        }

        bw.write(sb + "");
        bw.flush();
    }
}
