package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 15831 - 준표의 조약돌
 * https://www.acmicpc.net/problem/15831
 * 알고리즘 : 투 포인터
 */
public class 준표의조약돌_15831 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int B = Integer.parseInt(firstInput[1]);
        int W = Integer.parseInt(firstInput[2]);

        char[] arr = br.readLine().toCharArray();
        int ans = 0;
        int nextIndex = 0;
        int countB = 0;
        int countW = 0;
        for (int i = 0; i < N; i++) {
            while (arr.length > nextIndex) {
                char str = arr[nextIndex];
                if (str == 'B') {
                    if (countB + 1 > B) break;
                    countB++;
                    nextIndex++;
                } else if (str == 'W') {
                    countW++;
                    nextIndex++;
                }
            }

            if (countB <= B && countW >= W) {
                ans = Math.max(ans, countB + countW);
            }

            if (arr[i] == 'B') countB--;
            else countW--;
        }

        bw.write(ans + "");
        bw.flush();
    }
}
