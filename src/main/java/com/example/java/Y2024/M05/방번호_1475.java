package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 1475 - 방번호
 * https://www.acmicpc.net/problem/1475
 * 알고리즘 : 구현
 */
public class 방번호_1475 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");
        int[] arr = new int[10];
        for (int i = 0; i < input.length; i++) {
            int num = Integer.parseInt(input[i]);
            if (num == 6 || num == 9) {
                int i1 = arr[6];
                int i2 = arr[9];
                if (i1 > i2) {
                    arr[9]++;
                } else if (i1 < i2) {
                    arr[6]++;
                } else {
                    arr[num]++;
                }
            } else {
                arr[num]++;
            }
        }

        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (ans < arr[i]) {
                ans = arr[i];
            }
        }

        bw.write(ans + "");
        bw.flush();
    }
}
