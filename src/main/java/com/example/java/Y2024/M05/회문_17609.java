package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 17609 - 회문
 * https://www.acmicpc.net/problem/17609
 * 알고리즘 : 투 포인터
 */
public class 회문_17609 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] arr = br.readLine().toCharArray();
            int l = 0;
            int r = arr.length - 1;
            int ans = 0;
            while (l <= r) {
                if (arr[l] != arr[r]) {
                    if (isPalindrome(arr, l + 1, r) || isPalindrome(arr, l, r - 1)) {
                        ans = 1;
                    } else {
                        ans = 2;
                    }
                    break;
                }
                l++;
                r--;
            }
            bw.write(ans + "\n");
        }

        bw.flush();
    }

    private boolean isPalindrome(char[] arr, int l, int r) {
        while (l <= r) {
            if(arr[l] != arr[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}
