package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 11728 - 배열 합치기
 * https://www.acmicpc.net/problem/11728
 * 알고리즘 : 투 포인터
 */
public class 배열합치기_11728 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        String[] secondInput = br.readLine().split(" ");
        String[] thirdInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int M = Integer.parseInt(firstInput[1]);

        int[] arr1 = new int[N];
        int[] arr2 = new int[M];
        for (int i = 0; i < secondInput.length; i++) arr1[i] = (Integer.parseInt(secondInput[i]));
        for (int i = 0; i < thirdInput.length; i++) arr2[i] = (Integer.parseInt(thirdInput[i]));

        int indexArr1 = 0;
        int indexArr2 = 0;
        int index = 0;
        int[] ans = new int[N + M];
        while (N + M > index) {
            if (indexArr1 == N) {
                ans[index++] = arr2[indexArr2++];
                continue;
            }

            if (indexArr2 == M) {
                ans[index++] = arr1[indexArr1++];
                continue;
            }

            if (arr1[indexArr1] < arr2[indexArr2]) {
                ans[index++] = arr1[indexArr1++];
            } else {
                ans[index++] = arr2[indexArr2++];
            }
        }

        for (Integer integer : ans) {
            bw.write(integer + " ");
        }
        bw.flush();
    }
}
