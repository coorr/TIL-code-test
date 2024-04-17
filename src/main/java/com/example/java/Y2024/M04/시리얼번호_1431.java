package com.example.java.Y2024.M04;

import com.example.java.Main;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1431
public class 시리얼번호_1431 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Serial[] serial = new Serial[N];
        for (int i = 0; i < N; i++) {
            serial[i] = new Serial(br.readLine());
        }
        Arrays.sort(serial, (o1, o2) -> {
            if (o1.serial.length() != o2.serial.length())
                return o1.serial.length() - o2.serial.length();
            if (o1.sum != o2.sum)
                return o1.sum - o2.sum;
            return o1.serial.compareTo(o2.serial);
        });

        for (Serial s : serial) {
            bw.write(s.serial + "\n");
        }

        bw.flush();
    }

    class Serial {
        String serial;
        int sum;
        public Serial(String serial) {
            this.serial = serial;
            for (int i = 0; i < serial.length(); i++)
                if ('0' <= serial.charAt(i) && serial.charAt(i) <= '9')
                    sum += serial.charAt(i) - '0';
        }
    }
}
