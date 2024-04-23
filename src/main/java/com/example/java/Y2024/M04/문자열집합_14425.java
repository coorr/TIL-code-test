package com.example.java.Y2024.M04;

import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 14425 - 문자열 집합
 * https://www.acmicpc.net/problem/14425
 */
public class 문자열집합_14425 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        Arrays.sort(str);

        int ans = 0;
        for (int i = 0; i < M; i++) {
            boolean isExist = isExist(str, br.readLine());
            if (isExist) {
                ans++;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private boolean isExist(String[] arr, String verify) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int medium = (left + right) / 2;
            int compareResult = arr[medium].compareTo(verify);

            if(compareResult < 0) left = medium + 1;
            else if(compareResult > 0) right = medium -1;
            else return true;
        }
        return false;
    }
}
