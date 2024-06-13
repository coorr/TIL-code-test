package com.example.java.Y2024.M06;

import java.io.*;

/**
 * [BOJ] 6603 - 로또
 * https://www.acmicpc.net/problem/6603
 * 알고리즘 : 재귀
 */
public class 로또_6603 {
    static int k;
    static int[] s;
    static boolean[] visit;
    static int[] arr;

    private void DFS(int start, int depth) {
        if (depth == 6) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = s[i];
                DFS(i, depth + 1);
                visit[i] = false;
            }
        }
        return;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] st = br.readLine().split(" ");
            k = Integer.parseInt(st[0]);
            if(k == 0) break;

            s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st[i + 1]);
            }

            visit = new boolean[k];
            arr = new int[6];

            DFS(0, 0);
            System.out.println();
        }

        bw.flush();
    }
}
