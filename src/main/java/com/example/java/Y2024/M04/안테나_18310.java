package com.example.java.Y2024.M04;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/18310
// 집 위치에서 가장 가운데 기준으로 답을 구함
// 그러기 위해서 오름 차순 정렬이 필요.
// 짝수개이면 그 중앙이 안테나 적합
// 홀수개이면 가장 작은 값이 적합
public class 안테나_18310 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] locations = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i <N; i++) {
            locations[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(locations);
        bw.write(locations[(N - 1) / 2] + "");
        bw.flush();
    }
}
