package com.example.java.Y2024.M04;

import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 2470 - 두 용액
 * https://www.acmicpc.net/problem/2470
 */
public class 두용액_2470 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        String[] inputLine = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(inputLine[i]);
        }

        Arrays.sort(numbers);
        int ansAbs = Math.abs(numbers[0] + numbers[1]);
        int ans1 = numbers[0];
        int ans2 = numbers[1];

        for (int i = 0; i < N - 1; i++) {
            int optimalPairValue = findOptimalPair(numbers, numbers[i], i + 1, numbers.length - 1);
            int sumAbs = Math.abs(numbers[i] + optimalPairValue);
            if (ansAbs > sumAbs) {
                ansAbs = sumAbs;
                ans1 = numbers[i];
                ans2 = optimalPairValue;
            }
        }
        bw.write(ans1 + " " + ans2);
        bw.flush();
    }

    private int findOptimalPair(int[] numbers, int number, int fromIndex, int toIndex) {
        int optimalAbs = 200000001;
        int optimalPairValue = numbers[fromIndex];

        while (fromIndex <= toIndex) {
            int m = (fromIndex + toIndex) / 2;
            int sumAbs = Math.abs(number + numbers[m]);
            if (optimalAbs > sumAbs) {
                optimalAbs = sumAbs;
                optimalPairValue = numbers[m];
            }

            if (sumAbs < 0) {
                fromIndex = m + 1;
            } else if (sumAbs > 0) {
                toIndex = m - 1;
            } else {
                return numbers[m];
            }
        }
        return optimalPairValue;
    }
}
