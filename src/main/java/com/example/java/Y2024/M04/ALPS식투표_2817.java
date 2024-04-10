package com.example.java.Y2024.M04;

import java.io.*;

// https://www.acmicpc.net/problem/2817
public class ALPS식투표_2817 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int T = Integer.valueOf(br.readLine());
        float[][] scores = new float[T][15];
        String[] staffs = new String[T];
        int[] votes = new int[T];

        // 득표수 1~14로 나누기
        int index = 0;
        for (int i =0; i< T; i++) {
            String[] input = br.readLine().split(" ");
            staffs[i] = input[0];
            int vote = Integer.parseInt(input[1]);
            votes[i] = vote;
            for (int j = 0; j < 15; j++) {
                float score = (float) vote / (j + 1);
                scores[index][j] = score;
            }
            index++;
        }

        // 각 스태프의 가장 큰 투표수 저장 후 0으로 변경
        float[] maxScores = getEachStaffMaxScore(T, scores);

        // 가장 큰 투표수를 가진 스태프에게 1개 칩 추가
        int[] staffChips = addChipIfMaxScore(T, scores, maxScores);

        // 스태프 이름 정렬
        String[][] answers = sortedStaff(T, staffs, votes, staffChips);

        // 투표수가 5퍼센트 이상인 경우에 스태프 이름과 칩 출력
        for (int i = 0; i < T; i++) {
            String staff = answers[i][0];
            String chip = answers[i][1];
            String vote = answers[i][2];

            if (X * 0.05 <= Integer.parseInt(vote)) {
                bw.write(staff + " " + chip + "\n");
            }
        }

        bw.flush();
    }

    private String[][] sortedStaff(int T, String[] staffs, int[] votes, int[] staffChips) {
        String[][] answers = new String[T][3];
        for (int i = 0; i < T; i++) {
            int curIndex = 0;
            String name = staffs[i];
            int score = votes[i];
            int round = staffChips[i];
            for (int j = 0; j < T; j++) {
                if (staffs[i].charAt(0) > staffs[j].charAt(0)) {
                    curIndex++;
                }
            }

            answers[curIndex][0] = name;
            answers[curIndex][1] = String.valueOf(round);
            answers[curIndex][2] = String.valueOf(score);
        }
        return answers;
    }

    private int[] addChipIfMaxScore(int T, float[][] scores, float[] maxScores) {
        int[] staffChips = new int[T];
        for (int i = 0; i < 14; i++) {
            float max =0;
            int curIndex = 0;
            for (int j = 0; j < T; j++) {
                float score = maxScores[j];
                if (max < score) {
                    max = score;
                    curIndex = j;
                }
            }

            staffChips[curIndex]++;
            int nextIndex = 1;
            while (true) {
                if (scores[curIndex][nextIndex] > 0) {
                    maxScores[curIndex] = scores[curIndex][nextIndex];
                    scores[curIndex][nextIndex] = 0;
                    break;
                }
                nextIndex++;
            }
        }
        return staffChips;
    }

    private float[] getEachStaffMaxScore(int T, float[][] scores) {
        float[] maxScores = new float[T];
        for (int i = 0; i < T; i++) {
            maxScores[i] = scores[i][0];
            scores[i][0] = 0;
        }
        return maxScores;
    }
}
