package com.example.java.Y2024.M04;

import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 100816 - 숫자 카드 2
 * https://www.acmicpc.net/problem/10816
 */
public class 숫자카드2_10816 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        String[] firstLineInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(firstLineInput[i]);
            numbers[i] = num;
        }
        Arrays.sort(numbers);

        int M = Integer.parseInt(br.readLine());
        String[] secondInputLine = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(secondInputLine[i]);
            int lowerBoundValue = getLowerBoundValue(numbers, x);
            int upperBoundValue = getUpperBoundValue(numbers, x);
            bw.write(upperBoundValue - lowerBoundValue + " ");
        }

        bw.flush();
    }

    private int getLowerBoundValue(int[] numbers, int x) {
        int lowerBoundValue = numbers.length;
        int l = 0, r = numbers.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (numbers[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
                lowerBoundValue = m;
            }
        }

        return lowerBoundValue;
    }

    private int getUpperBoundValue(int[] numbers, int x) {
        int upperBoundValue = numbers.length;
        int l = 0, r = numbers.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (numbers[m] <= x) {
                l = m + 1;
            } else {
                r = m - 1;
                upperBoundValue = m;
            }
        }

        return upperBoundValue;
    }
}
