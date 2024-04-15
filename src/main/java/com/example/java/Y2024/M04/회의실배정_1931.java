package com.example.java.Y2024.M04;

import com.example.java.Main;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1931
public class 회의실배정_1931 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            meetings[i] = new Meeting(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        Meeting meeting = meetings[0];
        int count = 1;
        int end = meeting.end;
        for (int i = 1; i < N; i++) {
            if (end <= meetings[i].start) {
                count++;
                end = meetings[i].end;
            }
        }
        bw.write(count + "");
        bw.flush();
    }

    class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
