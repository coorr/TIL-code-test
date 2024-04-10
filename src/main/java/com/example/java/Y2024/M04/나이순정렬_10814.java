package com.example.java.Y2024.M04;

import com.example.java.Main;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10814
public class 나이순정렬_10814 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            students[i] = new Student(Integer.parseInt(input[0]), input[1]);
        }

        Arrays.sort(students, (o1, o2) -> o1.age - o2.age);

        for (Student student : students) {
            bw.write(student.age + " " + student.name + "\n");
        }
        bw.flush();
    }

    class Student {
        int age;
        String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
