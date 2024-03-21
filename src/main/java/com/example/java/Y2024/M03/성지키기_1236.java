package com.example.java.Y2024.M03;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1236
public class 성지키기_1236 {
    private void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] array = new char[n][m];
        int[] nArray = new int[n];
        int[] mArray = new int[m];

        for(int i = 0; i < n; i++) {
            char[] chars = scanner.next().toCharArray();
            int j = 0;
            for (char c : chars) {
                array[i][j] = c;
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (String.valueOf(array[i][j]).equals("X")) {
                    nArray[i] = 1;
                    mArray[j] = 1;
                }
            }
        }

        long N = Arrays.stream(nArray).filter(i -> i == 0).count();
        long M = Arrays.stream(mArray).filter(i -> i == 0).count();
        System.out.println(Math.max(N,M));
    }
}
