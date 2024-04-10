package com.example.java.Y2024.M04;

import com.example.java.Main;

import java.io.*;

// https://www.acmicpc.net/problem/2817
public class 개선_ALPS식투표_2817 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int T = Integer.valueOf(br.readLine());
        boolean[] isValidateStaff = new boolean[26];
        int[] votes = new int[26];
        int isValidateCount = 0;
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            char staff = input[0].charAt(0);
            int vote = Integer.parseInt(input[1]);

            if (X * 0.05 <= vote) {
                isValidateStaff[staff - 'A'] = true;
                isValidateCount++;
                votes[staff - 'A'] = vote;
            }
        }

        // ALPS식 스코어 1~14 나누어서 저장
        Score[] scores = generateScoreWithALPS(isValidateStaff, votes, isValidateCount);

        // 스코어 오름차순 정렬
        sortScoresDesendingOrder(scores);

        // 가장 높은 14개만 chip 추가
        int[] ans = new int[26];
        for (int i = 0; i < 14; i++) {
            ans[scores[i].staffIndex]++;
        }

        for (int i = 0; i < 26; i++) {
            if(isValidateStaff[i]) {
                bw.write((char) (i + 'A') + " " + ans[i] + "\n");
            }
        }


        bw.flush();
    }

    private Score[] generateScoreWithALPS(boolean[] isValidateStaff, int[] votes, int isValidateCount) {
        Score[] scores = new Score[isValidateCount * 14];
        int score_idx = 0;
        for (int i = 0; i < 26; i++) {
            if(!isValidateStaff[i]) continue;

            for (int j = 1; j < 15; j++) {
                scores[score_idx++] = new Score(i, (double) votes[i] / j);
            }
        }
        return scores;
    }

    private void sortScoresDesendingOrder(Score[] scores) {
        for (int i = 1; i < scores.length; i++) {
            for (int j = 0; j < i; j++) {
                if (scores[i].score > scores[j].score) {
                    Score temp = scores[i];

                    for (int k = i; k > j; k--) {
                        scores[k] = scores[k - 1];
                    }
                    scores[j] = temp;
                    break;
                }
            }
        }
    }

    class Score {
        int staffIndex;
        double score;

        public Score(int staffIndex, double score) {
            this.staffIndex = staffIndex;
            this.score = score;
        }
    }
}
