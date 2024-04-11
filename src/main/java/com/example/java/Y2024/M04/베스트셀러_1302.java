package com.example.java.Y2024.M04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/1302
public class 베스트셀러_1302 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        String maxTitle = "";
        int max = 0;

        for (Map.Entry<String, Integer> book : map.entrySet()) {
            String title = book.getKey();
            int count = book.getValue();

            if (max < count || (max == count && title.compareTo(maxTitle) < 0)) {
                max = count;
                maxTitle = title;
            }
        }

        bw.write(maxTitle);
        bw.flush();
    }
}
