package com.example.java.Y2024.M04;

import com.example.java.Main;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/7785
public class 회사에있는사람_7785 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Employee[] employees = new Employee[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            employees[i] = new Employee(input[0], input[1]);
        }

        Arrays.sort(employees, (o1, o2) -> o2.name.compareTo(o1.name));

        for (int i = 0; i < N - 1; i++) {
            if (employees[i].workStatus.equals("enter") && !employees[i].name.equals(employees[i + 1].name)) {
                bw.write(employees[i].name + "\n");
            }
        }

        if (employees[N - 1].workStatus.equals("enter")) {
            bw.write(employees[N - 1].name + "\n");
        }

        bw.flush();
    }

    class Employee {
        String name;
        String workStatus;

        public Employee(String name, String workStatus) {
            this.name = name;
            this.workStatus = workStatus;
        }
    }
}
