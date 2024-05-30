package com.example.java.Y2024.M05;

import com.example.java.Main;

import java.io.*;
import java.util.LinkedList;

/**
 * [BOJ] 1966 - 프린터 큐
 * https://www.acmicpc.net/problem/1966
 * 알고리즘 : 큐
 */
public class 프린터큐_1966 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] firstInput = br.readLine().split(" ");
            int N = Integer.parseInt(firstInput[0]);
            int M = Integer.parseInt(firstInput[1]);
            String[] secondInput = br.readLine().split(" ");
            LinkedList<Job> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) queue.add(new Job(i, Integer.parseInt(secondInput[i])));

            for (int i = 0; i < N; i++) {
                while (!isTopPriority(queue.peek().priority, queue)) {
                    queue.offer(queue.poll());
                }

                if (queue.peek().index == M) {
                    bw.write(i + 1 + "\n");
                    break;
                }
                queue.poll();
            }
        }

        bw.flush();
    }

    boolean isTopPriority(int priority, LinkedList<Job> queue) {
        LinkedList<Job> clone = (LinkedList<Job>) queue.clone();
        int size = clone.size();
        for (int i = 0; i < size; i++) {
            if (priority < clone.poll().priority) {
                return false;
            }
        }
        return true;
    }

    class Job {
        int index;
        int priority;

        public Job(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
