package com.example.java.Y2024.M08;

/**
 * [프로그래머스] 87390 - n^2승 배열 자르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * 알고리즘 : 구현
 */
public class n2승_배열자르기_87390 {
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        long l = left / n + 1;
        long r = left % n + 1;
        long mock = right - left + 1;

        for (int i = 0; i < mock; i++) {
            answer[i] = (int) Math.max(l, r);
            if(r + 1 == n + 1) {
                r = 1;
                l++;
            } else {
                r++;
            }
        }

        return answer;
    }
}
