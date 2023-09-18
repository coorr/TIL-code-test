package com.example.java.september;

import java.util.Scanner;

/**
 설명
 N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.

 입력
 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
 두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.

 출력
 N개의 좌표를 정렬하여 출력하세요.

 예시 입력 1
 5
 2 7
 1 3
 1 2
 2 5
 3 6

 예시 출력 1
 1 2
 1 3
 2 5
 2 7
 3 6

 */
public class 좌표정렬 {
    private void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = Integer.parseInt(scanner.next());
            arr[i][1] = Integer.parseInt(scanner.next());
        }

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][0] > arr[j][0]) {
                    sort(arr, i, j);
                }
            }
        }

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (yCondition(arr, i, j)) {
                    sort(arr, i, j);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }

    private void sort(int[][] arr, int i, int j) {
        int x = arr[i][0];
        int y = arr[i][1];

        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];

        arr[j][0] = x;
        arr[j][1] = y;
    }

    private boolean yCondition(int[][] arr, int i, int j) {
        return arr[i][0] == arr[j][0] && arr[i][1] > arr[j][1];
    }
}
