package com.example.java.Y2024.M05;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [BOJ] 5430 - AC
 * https://www.acmicpc.net/problem/5430
 * 알고리즘 : Deque
 */
public class AC_5430 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] p = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().replace("[", "").replace("]", "").split(",");
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(input[i]));
            }

            boolean isValid = true;
            boolean state = false;
            for (int i = 0; i < p.length; i++) {
                if (p[i].equals("D")) {
                    if (deque.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    if(state) deque.pollLast();
                    else deque.pollFirst();
                }
                else state = !state;
            }

            if (isValid) {
                StringBuffer sb = new StringBuffer();
                while (!deque.isEmpty()) {
                    sb.append(state ? deque.removeLast() : deque.removeFirst());
                    if(!deque.isEmpty()) sb.append(",");
                }
                bw.write("[" + sb + "]");
            }
            else bw.write("error");
            bw.write("\n");
        }

        bw.flush();
    }
}
