package com.example.java.Y2024.M06;

import java.io.*;
import java.util.ArrayList;

/**
 * [BOJ] 10597 - 순열 장난
 * https://www.acmicpc.net/problem/10597
 * 알고리즘 : 백트래킹
 */
public class 순열장난_10597 {
    static int n;
    static ArrayList<Integer> answer = new ArrayList<>();
    static char[] input;
    static int[] check = new int[101];

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = br.readLine().toCharArray();
        n = input.length > 9 ? 9 + (input.length - 9) / 2 : input.length;

        solve(0);
        bw.flush();
    }

    private void solve(int index) {
        // base case
        if (index >= input.length) {
            for (Integer i : answer) {
                System.out.print(i + " ");
            }
            System.exit(0);
        }

        // recursive case
        int target1 = atoi(input, index, 1);
        if (target1 <= n && check[target1] == 0) {
            check[target1]++;
            answer.add(target1);
            solve(index + 1);
            check[target1] = 0;
            answer.remove(answer.size() - 1);
        }
        if(index + 1 >= input.length) return;

        int target2 = atoi(input, index, 2);
        if (target2 <= n && check[target2] == 0) {
            check[target2]++;
            answer.add(target2);
            solve(index + 2);
            check[target2] = 0;
            answer.remove(answer.size() - 1);
        }
    }

    private int atoi(char[] input, int start, int length) {
        int result = 0;
        for (int i = start; i < start + length; i++) {
            result *= 10;
            result += input[i] - '0';
        }
        return result;
    }
}
