package com.example.java.Y2024.M04;

import java.io.*;

// https://www.acmicpc.net/problem/11659
// 일반 배열 순회를 통해서 구하면 시간 초과
// 누적합을 통해서 해결
public class 구간합구하기_11659 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] oneInput = br.readLine().split(" ");
        int N = Integer.parseInt(oneInput[0]);
        int M = Integer.parseInt(oneInput[1]);
        int[] nums = new int[N + 1];

        String[] twoInput = br.readLine().split(" ");
        int sum = 0;
        for (int i = 1; i < N + 1; i++) {
            sum += Integer.parseInt(twoInput[i -1]);
            nums[i] = sum;
        }

        for (int i = 0; i < M; i++) {
            String[] threeInput = br.readLine().split(" ");
            int a = Integer.parseInt(threeInput[0]);
            int b = Integer.parseInt(threeInput[1]);

            int aNum = nums[a - 1];
            int bNum = nums[b];

            bw.write(bNum - aNum + "\n");
        }

        bw.flush();
    }
}
