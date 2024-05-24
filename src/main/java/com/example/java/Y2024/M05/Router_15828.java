package com.example.java.Y2024.M05;

import com.example.java.Main;

import java.io.*;

/**
 * [BOJ] 15828 - Router
 * https://www.acmicpc.net/problem/15828
 * 알고리즘 : 큐(array queue)
 */
public class Router_15828 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayQueue<Integer> queue = new ArrayQueue<>(N);

        while (true) {
            String input = br.readLine();
            if (input.equals("-1")) break;
            if (input.equals("0")) queue.deQueue();
            else queue.enQueue(Integer.parseInt(input));
        }

        if(queue.isEmpty()) bw.write("empty");

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            bw.write(queue.deQueue() + " ");
        }
        bw.flush();
    }

    class ArrayQueue<E> {
        private Object[] data;
        private int frontIndex;
        private int rearIndex;
        private int capacity;
        private int size;

        public ArrayQueue(int maxCapacity) {
            data = new Object[maxCapacity];
            frontIndex = 0;
            rearIndex = -1;
            capacity = maxCapacity;
            size = 0;
        }

        public boolean enQueue(E element) {
            if(size == capacity) return false;

            rearIndex = (rearIndex + 1) % capacity;
            data[rearIndex] = element;
            size++;
            return true;
        }
        public E deQueue() {
            if(size == 0) return null;

            E value = (E) data[frontIndex];
            data[frontIndex] = null;
            frontIndex = (frontIndex + 1) % capacity;

            size--;
            return value;
        }

        public boolean isEmpty() {
            return size == 0;
        }
        public int size() {
            return size;
        }
        public E getFront() {
            return (E) data[frontIndex];
        }
        public E getRear() {
            return (E) data[rearIndex];
        }
    }
}
