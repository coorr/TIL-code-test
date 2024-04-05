package com.example.java.Y2024.M04;

import java.io.*;

// https://www.acmicpc.net/problem/10250
public class ACM호텔_10250 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int count = 1;
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int H = Integer.parseInt(input[0]);
            int W = Integer.parseInt(input[1]);
            int N = Integer.parseInt(input[2]);

            // 층수
            for (int j = 1; j <= W; j++) {
                // 호수
                for (int k = 1; k <= H; k++) {
                    if (count == N) {
                        if (j < 10) {
                            bw.write(k + "0" + j + "\n");
                        } else {
                            bw.write(k + "" + j + "\n");
                        }
                    }
                    count++;
                }
            }
            count = 1;
        }
        bw.flush();
    }
}
