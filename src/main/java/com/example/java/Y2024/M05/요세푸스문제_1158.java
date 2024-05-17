package com.example.java.Y2024.M05;

import java.io.*;
import java.util.LinkedHashMap;

/**
 * 1158 - 요세푸스 문제
 * https://www.acmicpc.net/problem/1158
 * 알고리즘 : 구현
 */
public class 요세푸스문제_1158 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        LinkedHashMap<Integer, Integer> list = new LinkedHashMap<>();
        for (int i = 1; i <= N; i++) list.put(i, i);

        int[] ans = new int[N];
        boolean[] removed = new boolean[N];
        int currentIndex = -1;
        for (int i = 0; i < N; i++) {
            int count = 0;
            while (count < K) {
                currentIndex = (currentIndex + 1) % N;
                if(!removed[currentIndex]) count++;
            }
            removed[currentIndex] = true;
            ans[i] = currentIndex + 1;
        }

        bw.write("<");
        for (int i = 0; i < N - 1; i++) {
            bw.write(ans[i] + ", ");
        }
        bw.write(ans[ans.length - 1] + "");
        bw.write(">");
        bw.flush();
    }
}
