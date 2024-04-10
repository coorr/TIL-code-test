package com.example.java.Y2024.M04;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1181
public class 단어정렬_1181 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            str[i] = input;
        }

        Arrays.sort(str, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        bw.write(str[0] + "\n");
        for (int i = 1; i < N; i++) {
            if (!str[i].equals(str[i - 1])) {
                bw.write(str[i] + "\n");
            }
        }

        bw.flush();
    }
}
