package com.example.java.Y2024.M06;

import java.io.*;

/**
 * [BOJ] 1987 - 알파벳
 * https://www.acmicpc.net/problem/1987
 * 알고리즘 : 재귀(퇴각검색)
 */
public class 알파벳_1987 {
    static int[][] board;
    static boolean[] check;
    static int[][] visited;
    static int r;
    static int c;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private boolean isOutOfBound(int row, int col, int boundR, int boundC) {
        return row < 0 || col < 0 || row >= boundR || col >= boundC;
    }


    private int solve(int row, int col) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i], nc = col + dc[i];
            if(isOutOfBound(nr, nc, r, c)) continue;
            int next = board[nr][nc];
            if(check[next]) continue;
            int route = 1 << next;
            if(visited[nr][nc] == (visited[row][col] | route)) continue;

            visited[nr][nc] = visited[row][col] | route;
            check[next] = true;
            int nextResult = solve(nr, nc);
            result = Math.max(result, nextResult);
            check[next] = false;
        }

        return result + 1;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] firstInput = br.readLine().split(" ");
        r = Integer.parseInt(firstInput[0]);
        c = Integer.parseInt(firstInput[1]);
        board = new int[r][c];
        visited = new int[r][c];
        check = new boolean[26];
        for (int i = 0; i < r; i++) {
            String[] secondInput = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                board[i][j] = secondInput[j].charAt(0) - 'A';
            }
        }

        check[board[0][0]] = true;
        bw.write(solve(0, 0) + "");
        bw.flush();
    }
}
