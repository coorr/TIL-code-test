package com.example.java.Y2024.M04;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;

// https://www.acmicpc.net/problem/2910
public class 빈도정렬_2910 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInputLine = br.readLine().split(" ");
        String[] secondInputLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstInputLine[0]);
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(secondInputLine[i]);
        }

        // 숫자에 대한 빈도 수 추가
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }

        // 빈도수 정렬
        Integer[] frequencies = map.keySet().toArray(new Integer[0]);
        Arrays.sort(frequencies, (o1, o2) -> map.get(o2) - map.get(o1));

        // 출력
        for (Integer integer : frequencies) {
            Integer count = map.get(integer);
            while (count-- > 0) {
                bw.write(integer + " ");
            }
        }
        bw.flush();
    }
}
