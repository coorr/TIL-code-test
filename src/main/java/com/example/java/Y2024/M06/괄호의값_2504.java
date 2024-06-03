package com.example.java.Y2024.M06;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * [BOJ] 2504 - 괄호의 값
 * https://www.acmicpc.net/problem/2504
 * 알고리즘 : deque
 */
public class 괄호의값_2504 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split("");
        int ans = 0;
        boolean isValid = true;
        Deque<String> deque = new ArrayDeque<>();
        for (String value : line) {
            if(value.equals("(") || value.equals("[")) deque.addLast(value);
            else {
                int count = 0;
                // 전에 계산했던 값을 가져오기
                while (isScore(deque.peekLast())) {
                    count += Integer.parseInt(Objects.requireNonNull(deque.pollLast()));
                }

                String poll = deque.pollLast();
                // 올바른 괄호인지 확인
                if (!isValid(poll, value)) {
                    isValid = false;
                    break;
                }

                // 전에 계산한 값이 필요하면 계산하고, 아니면 현재 괄호의 값 계산하고 deque 저장하기
                int num = poll.equals("(") ? 2 : 3;
                if(count == 0) deque.addLast(String.valueOf(num));
                else deque.addLast(String.valueOf(count * num));
            }
        }

        for (String str : deque) {
            if (!isScore(str)) {
                isValid = false;
                break;
            } else ans += Integer.parseInt(str);
        }

        if (isValid) bw.write(ans + "");
        else bw.write("0");

        bw.flush();
    }

    boolean isValid(String input, String str) {
        if(input == null) {
            return false;
        }
        if (str.equals("]") && input.equals("(")) {
            return false;
        }
        return !str.equals(")") || !input.equals("[");
    }

    boolean isScore(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
