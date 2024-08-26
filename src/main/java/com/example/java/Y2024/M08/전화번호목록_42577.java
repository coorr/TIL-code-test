package com.example.java.Y2024.M08;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * [프로그래머스] 42577 - 전화번호 목록
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * 알고리즘 : 브루트 포스
 */
public class 전화번호목록_42577 {
    public static boolean solution(String[] phone_book) {
        Set<String> tables = Arrays.stream(phone_book).collect(Collectors.toSet());
        for (String phone : tables) {
            for (int i = 1; i < phone.length(); i++) {
                String substring = phone.substring(0, i);
                if (tables.contains(substring)) {
                    return false;
                }
            }
        }
        return true;
    }
}
