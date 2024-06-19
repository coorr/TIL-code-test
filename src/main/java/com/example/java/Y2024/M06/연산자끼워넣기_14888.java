package com.example.java.Y2024.M06;

import java.io.*;

/**
 * [BOJ] 14888 - 연산자 끼워넣기
 * https://www.acmicpc.net/problem/14888
 * 알고리즘 : 재귀
 */
public class 연산자끼워넣기_14888 {
    static final int PLUS = 0;
    static final int MINUS = 1;
    static final int MUL = 2;
    static final int DIV = 3;
    static int N;
    static int[] numbers;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    private void solve(int index, int sum) {
        if (index == N) {
            if(sum > max) max = sum;
            if(sum < min) min = sum;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case PLUS:
                        solve(index + 1, sum + numbers[index]);
                        break;
                    case MINUS:
                        solve(index + 1, sum - numbers[index]);
                        break;
                    case MUL:
                        solve(index + 1, sum * numbers[index]);
                        break;
                    case DIV:
                        solve(index + 1, sum / numbers[index]);
                        break;
                }
                operator[i]++;
            }
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        String[] firstInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(firstInput[i]);
        }
        operator = new int[4];
        String[] secondInput = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(secondInput[i]);
        }

        solve(1, numbers[0]);

        bw.write(max + "\n" + min);
        bw.flush();
    }
}
