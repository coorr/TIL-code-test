package com.example.java.Y2024.M06;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [BOJ] 2841 - 외계인의 기타 연주
 * https://www.acmicpc.net/problem/2841
 * 알고리즘 : stack
 */
public class 외계인의기타연주_2841 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int P = Integer.parseInt(firstInput[1]);

        Deque<Integer>[] map = new ArrayDeque[7];
        for (int i = 1; i <= 6; i++) {
            map[i] = new ArrayDeque<>();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            String[] secondInput = br.readLine().split(" ");
            int num = Integer.parseInt(secondInput[0]);
            int fret = Integer.parseInt(secondInput[1]);

            Deque<Integer> values = map[num];
            while (!values.isEmpty()) {
                if (values.peekLast() > fret) {
                    values.pollLast();
                    ans++;
                }
                else break;
            }

            if (!values.isEmpty() && values.peekLast() == fret) {
                continue;
            }
            values.offerLast(fret);
            ans++;
        }
        bw.write(ans + "");
        bw.flush();
    }
}
