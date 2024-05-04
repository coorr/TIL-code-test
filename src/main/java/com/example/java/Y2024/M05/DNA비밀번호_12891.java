package com.example.java.Y2024.M05;

import java.io.*;
import java.util.HashMap;

/**
 * [BOJ] 12891 - DNA 비밀번호
 * https://www.acmicpc.net/problem/12891
 * 알고리즘 : 투 포인터 사용
 */
public class DNA비밀번호_12891 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        int S = Integer.parseInt(firstInput[0]);
        int P = Integer.parseInt(firstInput[1]);
        char[] secondInput = br.readLine().toCharArray();
        char[] sequence = new char[S];
        for (int i = 0; i < secondInput.length; i++) {
            sequence[i] = secondInput[i];
        }

        String[] thirdInput = br.readLine().split(" ");
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, Integer.parseInt(thirdInput[0]));
        map.put(1, Integer.parseInt(thirdInput[1]));
        map.put(2, Integer.parseInt(thirdInput[2]));
        map.put(3, Integer.parseInt(thirdInput[3]));

        int ans = 0;
        int[] accCount = new int[4];
        for (int i = 0; i < P - 1; i++) {
            accCount[baseToIndex(sequence[i])]++;
        }

        for (int i = P - 1; i < S; i++) {
            boolean isValid = true;
            accCount[baseToIndex(sequence[i])]++;
            for (int j = 0; j < 4; j++) {
                if (accCount[j] < map.get(j)) {
                    isValid = false;
                }
            }
            accCount[baseToIndex(sequence[i - (P - 1)])]--;
            if(isValid) ans++;
        }

        bw.write(ans + "");
        bw.flush();
    }

    private int baseToIndex(char c) {
        if (c == 'A') {
            return 0;
        } else if (c == 'C') {
            return 1;
        } else if (c == 'G') {
            return 2;
        } else {
            return 3;
        }
    }
}
