package com.example.java.Y2024.M03;

import java.io.*;

// https://www.acmicpc.net/problem/11005
public class 진번변환_11005 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int B = Integer.valueOf(input[1]);
        char[] array = new char[36];
        int index = 0;
        for (char c = '0'; c <= '9'; c++) array[index++] = c;
        for (char c = 'A'; c <= 'Z'; c++) array[index++] = c;

        char[] answer = new char[getCount(N, B)];
        int answerLen = 0;
        while (N > 0) {
            int reminder = N % B;
            answer[answerLen] = array[reminder];
            answerLen++;
            N /= B;
        }

        for (int i = answer.length - 1; i >= 0; i--) {
            bw.write(answer[i]);
        }
        bw.flush();
    }

    private int getCount(int N, int B) {
        int count = 0;
        while (N > 0) {
            N /= B;
            count++;
        }
        return count;
    }
}
