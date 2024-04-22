package com.example.java.Y2024.M04;

import java.io.*;
import java.util.Arrays;

/**
 * [BOG] 1920 - 수 찾기
 * https://www.acmicpc.net/problem/1920
 */
public class 수찾기_1920 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] oneLineInput = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] twoLineInput = br.readLine().split(" ");

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(oneLineInput[i]);
        Arrays.sort(numbers);

        for (int i = 0; i < M; i++) {
            int verifyNum = Integer.parseInt(twoLineInput[i]);

            boolean isExist = isExist(numbers, verifyNum);
            int ans = isExist ? 1 : 0;
            bw.write(ans + "\n");
        }

        bw.flush();
    }

    private boolean isExist(int[] numbers, int verifyNum) {
        int left = 0, right = numbers.length - 1;

        while (left <= right) {
            int medium = (left + right) / 2;
            if(numbers[medium] < verifyNum) left = medium + 1;
            else if(numbers[medium] > verifyNum) right = medium -1;
            else return true;
        }
        return false;
    }
}
