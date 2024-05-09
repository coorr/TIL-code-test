package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 16472 - 고냥이
 * https://www.acmicpc.net/problem/16472
 * 알고리즘 : 투 포인터
 */
public class 고냥이_16472 {
    int[] alphabetFrequency = new int[26];
    int alphabetCount = 0;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int ans = 0;
        int nextIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            while (nextIndex < arr.length) {
                increaseCount(arr[nextIndex++]);
                if (alphabetCount > N) {
                    decreaseCount(arr[--nextIndex]);
                    break;
                }
            }

            ans = Math.max(ans, nextIndex - i);
            decreaseCount(arr[i]);
        }

        bw.write(ans + "");
        bw.flush();
    }

    private void increaseCount(char alp) {
        if (alphabetFrequency[alp - 'a']++ == 0) {
            alphabetCount++;
        }
    }

    private void decreaseCount(char alp) {
        if (--alphabetFrequency[alp - 'a'] == 0) {
            alphabetCount--;
        }
    }
}
