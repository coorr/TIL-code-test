package com.example.java.Y2024.M07;

/**
 * [프로그래머스] JadenCase 문자열 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951#
 * 알고리즘 : 브루트포스
 */
public class JadenCase_문자열_만들기 {
    public String solution(String s) {
        String answer = "";
        String[] strings = s.split(" ", -1);
        for(int i = 0; i < strings.length; i++) {
            StringBuilder str = new StringBuilder(strings[i].toLowerCase());
            if(str.length() == 0) {
                answer += " ";
                continue;
            }

            String substring = str.substring(0, 1);
            if (!substring.chars().allMatch(Character::isDigit)) {
                substring = substring.toUpperCase();
                str.replace(0, 1, substring);
                strings[i] = String.valueOf(str);
            }
            answer += str + " ";
        }
        answer = answer.substring(0, answer.length() - 1);
        return answer;
    }
}
