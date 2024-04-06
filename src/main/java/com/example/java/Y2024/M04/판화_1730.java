package com.example.java.Y2024.M04;

import java.io.*;

// https://www.acmicpc.net/problem/1730
public class 판화_1730 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] table = new char[N][N];
        initializeTable(N, table);

        int x = 0;
        int y = 0;
        String str = br.readLine();
        for (char c : str.toCharArray()) {
            char originMark = table[x][y];
            // 오른쪽
            if (c == 'R' && y + 1 < N) {
                char nextMark = table[x][y + 1];
                modify(table, nextMark, '.', '-', x, y + 1);
                modify(table, nextMark, '|', '+', x, y + 1);
                modify(table, originMark, '.', '-', x, y);
                modify(table, originMark, '|', '+', x, y);
                y++;
            }
            // 왼쪽
            else if (c == 'L' && y - 1 >= 0) {
                char nextMark = table[x][y - 1];
                modify(table, nextMark, '.', '-', x, y - 1);
                modify(table, nextMark, '|', '+', x, y - 1);
                modify(table, originMark, '.', '-', x, y);
                modify(table, originMark, '|', '+', x, y);
                y--;
            }

            // 위
            else if (c == 'U' && x - 1 >= 0) {
                char nextMark = table[x - 1][y];
                modify(table, nextMark, '.', '|', x - 1, y);
                modify(table, nextMark, '-', '+', x - 1, y);
                modify(table, originMark, '.', '|', x, y);
                modify(table, originMark, '-', '+', x, y);
                x--;
            }
            // 아래
            else if (c == 'D' && x + 1 < N) {
                char nextMark = table[x + 1][y];
                modify(table, nextMark, '.', '|', x + 1, y);
                modify(table, nextMark, '-', '+', x + 1, y);
                modify(table, originMark, '.', '|', x, y);
                modify(table, originMark, '-', '+', x, y);
                x++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(table[i][j]);
            }
            bw.write("\n");
        }


        bw.flush();
    }

    private void modify(char[][] table, char originMark, char verifyMark, char modifyMark, int x, int y) {
        if (originMark == verifyMark) {
            table[x][y] = modifyMark;
        }
    }


    private void initializeTable(int N, char[][] table) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                table[i][j] = '.';
            }
        }
    }
}
