package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 1996 - 지뢰 찾기
 * https://www.acmicpc.net/problem/1996
 * 알고리즘 : 구현
 */
public class 지뢰찾기_1996 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = initializeArray(br, N);

        char[][] ans = new char[N][N];
        int[][] offsets = generateOffsets();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int value = arr[i][j];
                // 0 이상이면 지뢰로 변환
                if (value > 0) {
                    ans[i - 1][j - 1] = '*';
                    continue;
                }

                // 인접한 값 8가지 연산
                for (int[] offset : offsets) {
                    value += arr[i + offset[0]][j + offset[1]];
                }

                // 값이 10 이상이면 M 문자열 변환
                if (value >= 10) {
                    ans[i - 1][j - 1] = 'M';
                } else {
                    ans[i - 1][j - 1] = (char) (value + '0');
                }
            }
        }

        // 출력
        for (char[] an : ans) {
            for (char c : an) {
                bw.write(c);
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private int[][] initializeArray(BufferedReader br, int N) throws IOException {
        int[][] arr = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            String[] inputLine = br.readLine().split("");
            for (int j = 1; j <= N; j++) {
                String input = inputLine[j - 1];
                if (input.equals(".")) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = Integer.parseInt(input);
                }
            }
        }
        return arr;
    }

    private int[][] generateOffsets() {
        int[][] offsets = {
                {-1, -1}, {-1, 0}, {-1, 1},
                { 0, -1},         { 0, 1},
                { 1, -1}, { 1, 0}, { 1, 1}
        };
        return offsets;
    }
}
