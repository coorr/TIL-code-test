package com.example.java.Y2024.M06;

import java.io.*;

/**
 * [BOJ] 17136 - 색종이 붙이기
 * https://www.acmicpc.net/problem/17136
 * 알고리즘 : 재귀
 */
public class 색종이붙이기_17136 {
    static int[][] board = new int[11][11];
    static int result = 26;
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int nextRow = 0;
    static int nextCol = 0;

    private void findNext(int row) {
        for (int i = row; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 1) {
                    nextRow = i;
                    nextCol = j;
                    return;
                }
            }
        }
        nextRow = -1;
        nextCol = -1;
    }

    private boolean isValid(int row, int col, int size) {
        if(row + size > 10 || col + size > 10) return false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int color = board[row + i][col + j];
                if(color == 0) return false;
            }
        }
        return true;
    }

    private void fill(int row, int col, int size, int color) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[row + i][col + j] = color;
            }
        }
    }


    private void solve(int row, int col, int cnt) {
        if(result <= cnt) return;
        findNext(row);
        if (nextRow == -1 && nextCol == -1) {
            result = cnt;
            return;
        }

        int r = nextRow;
        int c = nextCol;

        for (int size = 1; size <= 5; size++) {
            if(paper[size] == 0) continue;
            if(!isValid(r, c, size)) continue;

            paper[size]--;
            fill(r, c, size, 0);
            solve(r, c, cnt + 1);
            fill(r, c, size, 1);
            paper[size]++;
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 10; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        solve(0, 0, 0);
        if(result == 26) bw.write("-1");
        else bw.write(result + "");

        bw.flush();
    }
}
