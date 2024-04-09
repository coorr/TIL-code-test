package com.example.java.Y2024.M04;

import java.io.*;

// https://www.acmicpc.net/problem/2840
public class 행운의바퀴_2840 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInput = br.readLine().split(" ");
        int N = Integer.parseInt(firstInput[0]);
        int K = Integer.parseInt(firstInput[1]);
        char[] answer = new char[N];
        for (int i = 0; i < N; i++) {
            answer[i] = '?';
        }

        boolean isNotLuck = true;
        int curIndex = 0;
        while (K-- > 0) {
            String[] secondInput = br.readLine().split(" ");
            int rotation = Integer.parseInt(secondInput[0]);
            char word = secondInput[1].charAt(0);

            int nextIndex = ((curIndex - rotation) % N + N) % N;
            if (answer[nextIndex] == '?') {
                answer[nextIndex] = word;
            } else if (answer[nextIndex] != word) {
                isNotLuck = false;
                break;
            }
            curIndex = nextIndex;
        }

        boolean isDuplication = isDuplication(answer);

        if (isNotLuck && isDuplication) {
            for (int i = 0; i < answer.length; i++) {
                bw.write(answer[(curIndex + i) % N] );
            }
        } else {
            bw.write("!");
        }
        bw.flush();
    }

    private boolean isDuplication(char[] answer) {
        boolean[] isExists = new boolean[26];
        for (int i = 0; i < answer.length; i++) {
            if(answer[i] == '?') continue;
            else if (isExists[answer[i] - 'A']) {
                return false;
            }
            isExists[answer[i] - 'A'] = true;
        }

        return true;
    }
}
