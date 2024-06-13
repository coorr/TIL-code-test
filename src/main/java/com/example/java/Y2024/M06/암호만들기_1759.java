package com.example.java.Y2024.M06;

import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 1759 - 암호 만들기
 * https://www.acmicpc.net/problem/1759
 * 알고리즘 : 재귀
 */
public class 암호만들기_1759 {
    static int L;
    static int C;
    static boolean[] visit;
    static char[] arr;
    static char[] ans;
    static String rule = "aeiou";

    private void solve(int start, int depth) {
        if (depth == L) {
            int count = 0;
            StringBuilder str = new StringBuilder();
            for (char an : ans) {
                if (rule.contains(String.valueOf(an))) count++;
                str.append(an);
            }
            // 최소 1개 모음과 최소 2개 자음인지 확인
            if (count > 0 && L - count >= 2) {
                System.out.println(str);
            }
            return;
        }

        // 순열이 아닌 조합으로 순서대로 조합하기
        for (int i = start; i < C; i++) {
            if (!visit[i]) {
                visit[i]= true;
                ans[depth] = arr[i];
                solve(i, depth + 1);
                visit[i] = false;
            }
        }
        return;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] st = br.readLine().split(" ");
        L = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);

        arr = new char[C];
        String[] st2 = br.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            for (char c : st2[i].toCharArray()) {
                arr[i] = c;
            }
        }
        Arrays.sort(arr);
        visit = new boolean[C];
        ans = new char[L];
        solve(0, 0);

        bw.flush();
    }
}
