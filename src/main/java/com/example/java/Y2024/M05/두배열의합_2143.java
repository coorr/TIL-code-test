package com.example.java.Y2024.M05;

import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 2143 - 두 배열의
 * https://www.acmicpc.net/problem/2143
 * 알고리즘 : 이분탐색
 */
public class 두배열의합_2143 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        String[] firstInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) arr1[i] = Integer.parseInt(firstInput[i]);

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        String[] secondInput = br.readLine().split(" ");
        for (int i = 0; i < M; i++) arr2[i] = Integer.parseInt(secondInput[i]);

        int[] partSum1 = getAllPartSum(arr1);
        int[] partSum2 = getAllPartSum(arr2);

        Arrays.sort(partSum2);
        long ans = 0;
        for (int sum1 : partSum1) {
            int x = T - sum1;
            int loweBoundIndex = getLoweBoundIndex(partSum2, x);
            int upperBoundIndex = getUpperBoundIndex(partSum2, x);
            ans += upperBoundIndex - loweBoundIndex;
        }

        bw.write(ans + "");
        bw.flush();
    }

    private int[] getAllPartSum(int[] arr) {
        int N = arr.length;
        int[] partSum = new int[N * (N + 1) / 2];
        int partSumIndex = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += arr[j];
                partSum[partSumIndex++] = sum;
            }
        }
        return partSum;
    }

    private int getLoweBoundIndex(int[] arr, int x) {
        int lowerBound = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if(arr[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
                lowerBound = m;
            }
        }
        return lowerBound;
    }

    private int getUpperBoundIndex(int[] arr, int x) {
        int upperBound = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if(arr[m] <= x) {
                l = m + 1;
            } else {
                r = m - 1;
                upperBound = m;
            }
        }
        return upperBound;
    }
}
