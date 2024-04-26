package com.example.java.Y2024.M04;

import java.io.*;

/**
 * [BOJ] 6326 - 용돈 관리
 * https://www.acmicpc.net/problem/6236
 * 주의할 점.. (엄청 삽질 함)
 * 1. 현재 인출해야 하는 카운트가 넘어가면 false, 카운트가 적으면 유효성이 있는 true
 * 2. 현재 금액이 최소 금액보다 클 수가 없음. (왜냐하면 문제에서 최소 금액을 구하기 때문에 현재 금액보다 클수가 없음)
 */
public class 용돈관리_6236 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLineInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstLineInput[0]);
        int M = Integer.parseInt(firstLineInput[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int l = 0, r = 1000000000, ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(arr,m,M)) {
                r = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private boolean isPossible(int[] useAmounts, int value, int maxCount) {
        int currentCount = 1;
        int currentAmount = value;
        for (int i = 0; i < useAmounts.length; i++) {
            int amount = useAmounts[i];
            if(amount > value) return false;
            if (currentAmount < amount) {
                if(currentCount == maxCount) return false;
                currentCount++;
                currentAmount = value;
            }
            currentAmount -= amount;
        }
        return true;
    }
}
