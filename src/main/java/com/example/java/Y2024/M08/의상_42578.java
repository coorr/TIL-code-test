package com.example.java.Y2024.M08;

import java.util.HashMap;
import java.util.Map;

/**
 * [프로그래머스] 42578 - 의상
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * 알고리즘 : 조합
 */
public class 의상_42578 {
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> list = new HashMap<>();
        for(String[] clothe : clothes) {
            String type = clothe[1];
            list.put(type, list.getOrDefault(type, 0) + 1);
        }

        for (Integer value : list.values()) {
            answer *= (value + 1);
        }
        return answer - 1;
    }
}
