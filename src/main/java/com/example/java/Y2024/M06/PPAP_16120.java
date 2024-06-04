package com.example.java.Y2024.M06;

import java.io.*;

/**
 * [BOJ] 16120 - PPAP
 * https://www.acmicpc.net/problem/16120
 * 알고리즘 : stack
 */
public class PPAP_16120 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] arr = br.readLine().toCharArray();
        char[] rewind = new char[arr.length];
        int len = 0;
        for (char ch : arr) {
            rewind[len++] = ch;
            if (len >= 4 && rewind[len - 4] == 'P' && rewind[len - 3] == 'P' && rewind[len - 2] == 'A' && rewind[len - 1] == 'P') {
                len -= 3;
            }
        }
        bw.write(len == 1 && rewind[0] == 'P' ? "PPAP" : "NP");

        bw.flush();
    }
}
