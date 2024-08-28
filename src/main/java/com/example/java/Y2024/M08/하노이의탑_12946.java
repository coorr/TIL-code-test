package com.example.java.Y2024.M08;

import java.util.ArrayList;
import java.util.List;

/**
 * [프로그래머스] 12946 - 하노이의 탑
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 * 알고리즘 : 재귀
 */
public class 하노이의탑_12946 {
    public static List<int[]> list = new ArrayList<>();

    public static int[][] solution(int n) {
        move(1, 2, 3, n);
        return list.stream().toArray(int[][] :: new);
    }

    public static void move(int start, int mid, int end, int stack) {
        if (stack == 0) {
            return;
        }

        move(start, end, mid, stack - 1);
        list.add(new int[]{start, end});
        move(mid, start, end, stack - 1);
    }
}
