package com.example.java.Y2024.M05;


import java.io.*;
import java.util.Arrays;

/**
 * [BOJ] 10025 - 게으른 백곰
 * https://www.acmicpc.net/problem/10025
 * 알고리즘 : 투 포인터
 */
public class 게으른백곰_10025 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int K = Integer.parseInt(firstInput[1]);
        Bucket[] buckets = new Bucket[N];
        for (int i = 0; i < N; i++) {
            String[] secondInput = br.readLine().split(" ");
            int g = Integer.parseInt(secondInput[0]);
            int x = Integer.parseInt(secondInput[1]);
            buckets[i] = new Bucket(g, x);
        }

        Arrays.sort(buckets, (o1, o2) -> o1.x - o2.x);

        int nextIndex = 0;
        int maxSum = 0;
        int currentSum = 0;
        for (int i = 0; i < N; i++) {
            while (nextIndex < N && buckets[nextIndex].x - buckets[i].x <= 2 * K) {
                currentSum += buckets[nextIndex++].g;
            }
            maxSum = Math.max(maxSum, currentSum);
            currentSum -= buckets[i].g;
        }
        bw.write(maxSum + "");
        bw.flush();
    }

    class Bucket {
        int g;
        int x;
        Bucket(int g, int x) {
            this.g = g;
            this.x = x;
        }
    }
}
