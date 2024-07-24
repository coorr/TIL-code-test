package com.example.java.Y2024.M07;

/**
 * [프로그래머스] x만큼 간격이 있는 n개의 숫자
 * https://school.programmers.co.kr/learn/courses/30/lessons/12954
 * 알고리즘 : 브루트포스
 */
public class x만큼_간격이_있는_n개의_숫자 {
    class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            for (int i = 0; i < n; i++) {
                answer[i] = (long )x * (i + 1);
            }
            return answer;
        }
    }
}
