package com.example.java.Y2024.M04;

import java.io.*;

/**
 * [BOJ] 17232 - 생명 게임
 * https://www.acmicpc.net/problem/17232
 */
public class 생명게임_17232 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] oneInput = br.readLine().split(" ");
        int N = Integer.parseInt(oneInput[0]);
        int M = Integer.parseInt(oneInput[1]);
        int T = Integer.parseInt(oneInput[2]);

        String[] twoInput = br.readLine().split(" ");
        int k = Integer.parseInt(twoInput[0]);
        int a = Integer.parseInt(twoInput[1]);
        int b = Integer.parseInt(twoInput[2]);

        char[][] baduk = new char[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                baduk[i][j] = c[j - 1];
            }
        }

        while (T-- > 0) {
            // 생명 누적합 구하기
            int[][] acc = getPrefixSum(baduk);

            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < M + 1; j++) {
                    // 현재 칸의 생명 개수를 누적합에서 가져오기
                    int alive = getRangeSum(acc, i, j, k);
                    if (baduk[i][j] == '*') {
                        alive--;
                        if (a > alive || b < alive) {
                            baduk[i][j] = '.';
                        }
                    } else if (a < alive && b >= alive) {
                        baduk[i][j] = '*';
                    }
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                bw.write(baduk[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
    }

    private int[][] getPrefixSum(char[][] baduk) {
        int[][] acc = new int[baduk.length][baduk[0].length];
        for (int i = 1; i < baduk.length; i++) {
            for (int j = 1; j < baduk[0].length; j++) {
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + (baduk[i][j] == '*' ? 1 : 0);
            }
        }
        return acc;
    }

    private int getRangeSum(int[][] acc, int r, int c, int k) {
        int r1 = Math.max(r - k, 1);
        int c1 = Math.max(c - k, 1);
        int r2 = Math.min(r + k, acc.length - 1);
        int c2 = Math.min(c + k, acc[0].length - 1);
        return acc[r2][c2] - acc[r2][c1 - 1] - acc[r1 - 1][c2] + acc[r1 - 1][c1 - 1];
    }
}
