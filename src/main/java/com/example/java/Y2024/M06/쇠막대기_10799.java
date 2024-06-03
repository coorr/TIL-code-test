package com.example.java.Y2024.M06;

import java.io.*;

/**
 * [BOJ] 10799 - 쇠막대기
 * https://www.acmicpc.net/problem/10799
 * 알고리즘 : stack
 */
public class 쇠막대기_10799 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split("");
        int count = 0;
        int ans = 0;
        if (line[0].equals("(")) {
            count++;
        }
        for (int i = 1; i < line.length; i++) {
            if (line[i].equals("(")) {
                count++;
            } else {
                count--;
                if (line[i - 1].equals("(")) {
                    ans += count;
                }
                else ans++;
            }
        }

        bw.write(ans + "");
        bw.flush();
    }
}
