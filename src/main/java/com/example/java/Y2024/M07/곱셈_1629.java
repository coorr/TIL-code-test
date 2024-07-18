package com.example.java.Y2024.M07;

import java.io.*;

/**
 * [BOJ] 1629 - 곱셈
 * https://www.acmicpc.net/problem/1629
 * 알고리즘 : 재귀(분할)
 */
public class 곱셈_1629 {
    static int a;
    static int b;
    static int c;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        bw.write(power(a, b) + "");
        bw.flush();
    }
    private long power(int a, int b) {
        if(b == 1) return a % c;
        long half = power(a, b / 2);
        if (b % 2 == 0) {
            return (half * half) % c;
        } else {
            return (((half * half) % c) * a) % c;
        }
    }

}
