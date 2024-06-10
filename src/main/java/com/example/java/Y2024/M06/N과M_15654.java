package com.example.java.Y2024.M06;

import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 15654 - N과 M
 * https://www.acmicpc.net/problem/15654
 * 알고리즘 : 재귀
 */
public class N과M_15654 {
    static int N;
    static int M;
    static int[] output;
    static boolean[] check;
    static int[] input;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        N = Integer.parseInt(firstInput[0]);
        M = Integer.parseInt(firstInput[1]);
        String[] secondInput = br.readLine().split(" ");
        output = new int[M];
        check = new boolean[N];
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(secondInput[i]);
        }
        Arrays.sort(input);
        perm(0, bw);

        bw.flush();
    }

    private void perm(int depth, BufferedWriter bw) throws IOException{
        if (depth == M) {
            for (int i = 0; i < output.length; i++) {
                bw.write(output[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                output[depth] = input[i];
                perm(depth + 1, bw);
                check[i] = false;
            }
        }
    }
}
