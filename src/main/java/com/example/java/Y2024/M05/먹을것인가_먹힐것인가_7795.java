package com.example.java.Y2024.M05;

import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 7795 - 먹을 것인가 먹힐 것인가
 * https://www.acmicpc.net/problem/7795
 * 알고리즘 : 투포인터
 */
public class 먹을것인가_먹힐것인가_7795 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] firstInput = br.readLine().split(" ");
            int A = Integer.parseInt(firstInput[0]);
            int B = Integer.parseInt(firstInput[1]);
            String[] inputA = br.readLine().split(" ");
            String[] inputB = br.readLine().split(" ");
            int[] arrA = new int[A];
            int[] arrB = new int[B];
            for (int i = 0; i < A; i++) arrA[i] = Integer.parseInt(inputA[i]);
            for (int i = 0; i < B; i++) arrB[i] = Integer.parseInt(inputB[i]);
            Arrays.sort(arrA);
            Arrays.sort(arrB);

            int ans = 0;
            int bi = 0;
            for (int i = 0; i < A; i++) {
                while (bi < B && arrA[i] > arrB[bi]) bi++;
                ans += bi;
            }
            bw.write(ans + "\n");
        }
        bw.flush();
    }
}
