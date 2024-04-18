package com.example.java.Y2024.M04;

import java.io.*;

/**
 * [BOJ] 19951 - 태상이의 훈련소 생활
 * https://www.acmicpc.net/problem/19951
 * 알고리즘 : 누적합
 */
public class 태상이의_훈련소생활_19951 {
    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] oneInput = br.readLine().split(" ");
        int N = Integer.parseInt(oneInput[0]);
        int M = Integer.parseInt(oneInput[1]);
        String[] twoInput = br.readLine().split(" ");
        int[] origin = initOrigin(twoInput, N);

        // delta에 k의 변화량을 저장한다.
        // >> 시작하는 부분은 +K
        // >> 끝나는 부분은 -K
        int[] delta = new int[N + 2];
        for (int i = 0; i < M; i++) {
            String[] threeInput = br.readLine().split(" ");
            int a = Integer.parseInt(threeInput[0]);
            int b = Integer.parseInt(threeInput[1]);
            int k = Integer.parseInt(threeInput[2]);

            delta[a]+=k;
            delta[b + 1]-=k;
        }

        // 각 칸부터 변화량을 적용한다. (이게 범위 누적합의 핵심)
        int[] accDelta = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            accDelta[i] = accDelta[i - 1] + delta[i];
        }

        // 출력
        for (int i = 1; i <= N; i++) {
            bw.write(origin[i] + accDelta[i] + " ");
        }

        bw.flush();
    }

    private int[] initOrigin(String[] twoInput, int N) {
        int[] heights = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(twoInput[i - 1]);
        }
        return heights;
    }
}
