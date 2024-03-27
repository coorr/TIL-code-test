package com.example.java.Y2024.M03;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10431
public class 줄세우기_10431 {
    private void solution() {
        Scanner scanner = new Scanner(System.in);
        int P = scanner.nextInt();

        for (int i = 0; i < P; i++) {
            int N = scanner.nextInt();
            int[] array = new int[20];
            for (int j = 0; j < 20; j++) {
                array[j] = scanner.nextInt();
            }

            System.out.println(N + " " + getCount(array));
        }
    }

    // 1. 내 앞에 있는 사람들 중에서 큰 사람이 있는지 찾는다.
    // 1-1 찾으면 그 뒤로 가고 뒤에 있는 사람들을 한칸씩 뒤로 보낸다.
    // 1-2 못찾으면 맨 뒤로 간다.
    private int getCount(int[] array) {
        int[] sorted = new int[20];
        int count = 0;
        for (int i = 0; i < 20; i++) {
            boolean find = false;
            for (int j = 0; j < i; j++) {
                if (sorted[j] > array[i]) {
                    for (int k = i - 1; k >= j; k--) {
                        sorted[k + 1] = sorted[k];
                        count++;
                    }
                    sorted[j] = array[i];
                    find = true;
                    break;
                }
            }
            if (!find) {
                sorted[i] = array[i];
            }
        }

        return count;
    }
}
