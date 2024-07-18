package com.example.java.Y2024.M07;

import java.io.*;

/**
 * [BOJ] 1074 - Z
 * https://www.acmicpc.net/problem/1074
 * 알고리즘 : 재귀(분할)
 */
public class Z_1074 {
    static int n;
    static int r;
    static int c;
    static int count = 0;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        solve(n, r, c);
        bw.write(count + "");
        bw.flush();
    }

    private void solve(int n, int r, int c) {
        int boardSize = 1 << n;
        int mid = boardSize / 2;
        if(n == 0) return;

        if (r < mid && c < mid) {
            solve(n - 1, r, c);
        } else if (r < mid && c >= mid) {
            count += mid * mid;
            solve(n - 1, r, c - mid);
        } else if (r >= mid && c < mid) {
            count += mid * mid * 2;
            solve(n - 1, r - mid, c);
        } else if (r >= mid && c >= mid) {
            count += mid * mid * 3;
            solve(n - 1, r - mid, c - mid);
        }
    }
}
