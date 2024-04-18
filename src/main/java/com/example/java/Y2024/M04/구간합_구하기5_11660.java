package com.example.java.Y2024.M04;

import java.io.*;

/**
 * [BOJ] 16713 - 구간 합 구하기 5
 * https://www.acmicpc.net/problem/11660
 */
public class 구간합_구하기5_11660 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] oneInput = br.readLine().split(" ");
        int N = Integer.parseInt(oneInput[0]);
        int M = Integer.parseInt(oneInput[1]);
        int[][] table = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String[] twoInput = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                table[i][j] = Integer.parseInt(twoInput[j - 1]);
            }
        }

        // 누적합 구하기 식 : 이번 원소 + 필요한 누적합(위, 왼쪽) - 중복 원소
        // 식 : 이번 원소 + 누적합(x-1) + 누적합 (y-1) + 누적합(x-1,y-1)
        int[][] accumulate = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                accumulate[i][j] = accumulate[i - 1][j] + accumulate[i][j - 1] - accumulate[i - 1][j - 1] + table[i][j];
            }
        }

        // 누적합 배열을 통해 구간합 구하고 - (r2, c2)
        // 불필요한 값을 뺴준다. - (r1-1, c2), (r2, c1-1)
        // 중복되는 값은 더해준다. - (r1-1, c1-1)
        for (int i = 0; i < M; i++) {
            String[] threeInput = br.readLine().split(" ");
            int r1 = Integer.parseInt(threeInput[0]);
            int c1 = Integer.parseInt(threeInput[1]);
            int r2 = Integer.parseInt(threeInput[2]);
            int c2 = Integer.parseInt(threeInput[3]);

            bw.write(accumulate[r2][c2] - accumulate[r1 - 1][c2] - accumulate[r2][c1 - 1] + accumulate[r1 - 1][c1 - 1] + "\n");
        }

        bw.flush();
    }
}
