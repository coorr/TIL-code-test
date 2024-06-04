package com.example.java.Y2024.M06;

import java.io.*;
import java.util.ArrayDeque;

/**
 * [BOJ] 5397 - 키로거
 * https://www.acmicpc.net/problem/5397
 * 알고리즘 : stack
 */
public class 키로거_5397 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] line = br.readLine().split("");
            ArrayDeque<String> beforeCursor = new ArrayDeque<>();
            ArrayDeque<String> afterCursor = new ArrayDeque<>();

            for (String str : line) {
                if (str.equals("-")) {
                    beforeCursor.pollLast();
                } else if (str.equals("<")) {
                    if (!beforeCursor.isEmpty()) {
                        afterCursor.offerLast(beforeCursor.pollLast());
                    }
                } else if (str.equals(">")) {
                    if (!afterCursor.isEmpty()) {
                        beforeCursor.offerLast(afterCursor.pollLast());
                    }
                } else {
                    beforeCursor.add(str);
                }
            }

            StringBuilder sb = new StringBuilder();
            while(!beforeCursor.isEmpty()) sb.append(beforeCursor.pollFirst());
            while(!afterCursor.isEmpty()) sb.append(afterCursor.pollLast());
            bw.write(sb + "\n");
        }

        bw.flush();
    }
}
