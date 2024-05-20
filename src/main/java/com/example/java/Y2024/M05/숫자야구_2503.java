package com.example.java.Y2024.M05;

import java.io.*;

/**
 * [BOJ] 2503 - 숫자 야구
 * https://www.acmicpc.net/problem/2503
 * 알고리즘 : 구현
 */
public class 숫자야구_2503 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) str[i] = br.readLine();

        int ans = 0;
        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if(i == j || k == j || k == i) continue;
                    boolean isFind = false;
                    for (int l = 0; l < N; l++) {
                        String[] string = str[l].split(" ");
                        String[] num = string[0].split("");
                        int i1 = Integer.parseInt(num[0]);
                        int i2 = Integer.parseInt(num[1]);
                        int i3 = Integer.parseInt(num[2]);
                        int strike = Integer.parseInt(string[1]);
                        int ball = Integer.parseInt(string[2]);

                        if(i == i1) strike--;
                        if(i == i2 || i == i3) ball--;
                        if(j == i2) strike--;
                        if(j == i1 || j == i3) ball--;
                        if(k == i3) strike--;
                        if(k == i1 || k == i2) ball--;

                        if (strike == 0 && ball == 0) {
                            isFind = true;
                        } else {
                            isFind = false;
                            break;
                        }
                    }

                    if(isFind) ans++;
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
    }
}
