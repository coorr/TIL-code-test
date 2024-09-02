package com.example.java.Y2024.M09;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * [프로그래머스] 42586 - 기능개발
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * 알고리즘 : 구현, 스택/큐
 */
public class 기능개발_42586 {
    /** 알고리즘 : 구현 */
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        while (index < progresses.length) {
            for (int i = index; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            int progress = progresses[index];
            int count = 0;
            if (progress >= 100) {
                count++;
                index++;
                for (int i = index; i < progresses.length; i++) {
                    int nextProgress = progresses[i];
                    if (nextProgress >= 100) {
                        index++;
                        count++;
                    } else {
                        break;
                    }
                }

                list.add(count);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    /** 알고리즘 : 스택/큐 */
    public static int[] solution1(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> dequeProgresses = new ArrayDeque<>();
        ArrayDeque<Integer> dequeSpeeds = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            dequeProgresses.add(progresses[i]);
            dequeSpeeds.add(speeds[i]);
        }

        while (!dequeProgresses.isEmpty()) {
            for (int i = 0; i < dequeProgresses.size(); i++) {
                int progress = dequeProgresses.pollFirst();
                int speed = dequeSpeeds.pollFirst();
                dequeProgresses.add(progress + speed);
                dequeSpeeds.add(speed);
            }

            Integer value = dequeProgresses.peekFirst();
            int count = 0;
            if (value >= 100) {
                count++;
                dequeProgresses.pollFirst();
                dequeSpeeds.pollFirst();

                int size = dequeSpeeds.size();
                for (int i = 0; i < size; i++) {
                    Integer progress = dequeProgresses.peekFirst();
                    if (progress >= 100) {
                        count++;
                        dequeProgresses.pollFirst();
                        dequeSpeeds.pollFirst();
                        continue;
                    }
                    break;
                }
                list.add(count);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
