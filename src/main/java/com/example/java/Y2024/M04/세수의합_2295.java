package com.example.java.Y2024.M04;

import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 2295 - 세 수의 합
 * https://www.acmicpc.net/problem/2295
 * A + B = C - K 의 식 활용
 * A + B 에 대한 값을 sums 저장
 * C - K 값이 sums 의 이분 탐색으로 찾아서 같으면 true
 * true 중에서 가장 큰 값을 찾음.
 */
public class 세수의합_2295 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int[] sums = new int[N * (N + 1) / 2];
        int sumIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sums[sumIndex++] = numbers[i] + numbers[j];
            }
        }

        Arrays.sort(sums);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int target = numbers[i] - numbers[j];
                if (isExist(sums, target)) {
                    ans = Math.max(ans, numbers[i]);
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }

    private boolean isExist(int[] sums, int value) {
        int left = 0;
        int right = sums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (sums[middle] < value) {
                left = middle + 1;
            } else if (sums[middle] > value) {
                right = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
