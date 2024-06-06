package com.example.java.Y2024.M06;

import java.io.*;
import java.util.ArrayDeque;

/**
 * [BOJ] 17298 - 오큰수
 * https://www.acmicpc.net/problem/17298
 * 알고리즘 : stack
 */
public class 오큰수_17298 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            deque.addLast(Integer.parseInt(input[i]));
        }

        ArrayDeque<Integer> temp = new ArrayDeque<>();
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            int value = deque.pollLast();
            while (!temp.isEmpty()) {
                if (temp.peekLast() <= value) {
                    temp.pollLast();
                }
                else break;
            }
            ans[i] = temp.isEmpty() ? -1 : temp.peekLast();
            temp.offerLast(value);
        }

        for (int i = N - 1; i >= 0; i--) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}
