package com.example.java.Y2024.M06;

import java.io.*;

/**
 * [BOJ] 1182 - 부분 수열의 합
 * https://www.acmicpc.net/problem/1182
 * 알고리즘 : 재귀
 */
public class 부분수열의합_1182 {
    static int[] arr;
    static int n;
    static int s;
    static int ans;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        n = Integer.parseInt(firstInput[0]);
        s = Integer.parseInt(firstInput[1]);
        String[] secondInput = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secondInput[i]);
        }

        solve(0, 0);

        bw.write(ans + " ");
        bw.flush();
    }

    private static void solve(int index, int sum) {
        if(index == arr.length) return;
        if(sum + arr[index] == s) ans++;

        solve(index + 1, sum + arr[index]);
        solve( index + 1, sum);
    }
}
