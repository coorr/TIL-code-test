package com.example.java.Y2024.M04;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

// https://www.acmicpc.net/problem/18870
public class 좌표압축_18870 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] coordinates = new int[N];
        for (int i = 0; i < N; i++) {
            coordinates[i] = Integer.parseInt(input[i]);
        }

        // 내림차순으로 정렬
        Arrays.sort(coordinates);

        // 중복되지 않는 좌표의 개수 저장
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            int coordinate = coordinates[i];

            if (coordinate != coordinates[i + 1]) {
                map.put(coordinate, count);
                count++;
            }
        }

        // 입력된 순서대로 좌표의 개수 호출
        map.put(coordinates[N - 1], count);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(input[i]);
            bw.write(map.get(num) + " ");
        }
        bw.flush();
    }
}
