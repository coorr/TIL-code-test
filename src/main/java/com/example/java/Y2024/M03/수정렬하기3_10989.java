package com.example.java.Y2024.M03;

import java.io.*;

public class 수정렬하기3_10989 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[10001];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            array[num]++;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                for (int j = 0; j < array[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }

        bw.flush();
    }
}
