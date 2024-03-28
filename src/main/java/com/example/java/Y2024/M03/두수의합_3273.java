package com.example.java.Y2024.M03;

import java.io.*;

// https://www.acmicpc.net/problem/3273
public class 두수의합_3273 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] exists = new int[1000001];
        int[] arr = new int[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0 ; i < line.length; i++) {
            int num = Integer.parseInt(line[i]);
            exists[num]++;
            arr[i] = num;
        }

        int X = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i =0; i < arr.length; i++) {
            int num = X - arr[i];
            if (num > 0 && num <= 1000000 && exists[num] > 0) {
                count++;
            }
        }
        count = count / 2;
        bw.write(count + "\n");

        bw.flush();
    }
}
