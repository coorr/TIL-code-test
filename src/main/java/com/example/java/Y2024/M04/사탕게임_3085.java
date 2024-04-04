package com.example.java.Y2024.M04;

import java.io.*;

// https://www.acmicpc.net/problem/3085
public class 사탕게임_3085 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] candies = new char[N][N];
        initializeCandies(br, N, candies);

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char value = candies[i][j];

                // 오른쪽
                if (j + 1 < N && value != candies[i][j + 1]) {
                    swapCandy(candies, i, j, i, j + 1);
                    max = Math.max(max, Math.max(getColumnMax(candies), getRowMax(candies)));
                    swapCandy(candies, i, j, i, j + 1);
                }

                // 아래
                if (i + 1 < N && value != candies[i + 1][j]) {
                    swapCandy(candies, i, j, i + 1, j);
                    max = Math.max(max, Math.max(getColumnMax(candies), getRowMax(candies)));
                    swapCandy(candies, i, j, i + 1, j);
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
    }

    // 사탕 변경
    private void swapCandy(char[][] candies, int i, int j, int iSwap, int jSwap) {
        char current = candies[i][j];
        char swapCandy = candies[iSwap][jSwap];

        candies[i][j] = swapCandy;
        candies[iSwap][jSwap] = current;
    }

    // 모든 열 체크
    private int getColumnMax(char[][] candies) {
        int max = 0;


        // 행
        for (int i = 0; i < candies.length; i++) {
            int len = 1;
            for (int j = 1; j < candies.length; j++) {
                char value = candies[j][i];
                char value2 = candies[j - 1][i];
                if (value == value2) {
                    len++;
                } else {
                    max = Math.max(max, len);
                    len = 1;
                }
            }
            max = Math.max(max, len);
        }

        return max;
    }

    // 모든 행 체크
    private int getRowMax(char[][] candies) {
        int max = 0;

        // 행
        for (int i = 0; i < candies.length; i++) {
            int len = 1;

            for (int j = 1; j < candies.length; j++) {
                char value = candies[i][j];
                char value2 = candies[i][j - 1];
                if (value == value2) {
                    len++;
                } else {
                    max = Math.max(max, len);
                    len = 1;
                }
            }
            max = Math.max(max, len);
        }

        return max;
    }

    private void initializeCandies(BufferedReader br, int N, char[][] candies) throws IOException {
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                candies[i][j] = str.charAt(j);
            }
        }
    }
}
