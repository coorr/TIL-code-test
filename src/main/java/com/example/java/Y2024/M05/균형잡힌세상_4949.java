package com.example.java.Y2024.M05;

import java.io.*;
import java.util.ArrayDeque;

/**
 * [BOJ] 4949 - 균형잡힌세상
 * https://www.acmicpc.net/problem/4949
 * 알고리즘 : Deque
 */
public class 균형잡힌세상_4949 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            String[] line = str.split("");
            ArrayDeque<String> deque = new ArrayDeque<>();
            for (String s : line) {
                if (s.equals("(") || s.equals("[")) {
                    deque.add(s);
                }
                if (s.equals(")")) {
                    String value = deque.pollLast();
                    if (value == null || !value.equals("(")) {
                        bw.write("no");
                        break;
                    }
                }
                if (s.equals("]")) {
                    String value = deque.pollLast();
                    if(value == null || !value.equals("[")) {
                        bw.write("no");
                        break;
                    }
                }
                if (s.equals(".")) {
                    String ans = deque.isEmpty() ? "yes" : "no";
                    bw.write(ans);
                    break;
                }
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
