package com.example.java.Y2024.M03;

import java.io.*;

public class 유레카이론_10448 {
    private static boolean[] isEurekaNumber = new boolean[1001];
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        preprocess();
        for (int i = 0; i < T; i++) {
            int number =  Integer.parseInt(br.readLine());
            int answer = isEurekaNumber[number] ? 1 : 0;
            bw.write(answer + "\n");
        }

        bw.flush();
    }

    private static void preprocess() {
        int[] eurekaArray = new int[44];
        addEurekaArray(eurekaArray);

        boolean[] isSumOfTriangleNumber = new boolean[1001];
        for (int i = 0; i < eurekaArray.length; i++) {
            for (int j = 0; j < eurekaArray.length; j++) {
                int sum = eurekaArray[i] + eurekaArray[j];
                if (sum < 1000) {
                    isSumOfTriangleNumber[sum] = true;
                }
            }
        }

        for (int i = 0; i < 1000; i++) {
            if(!isSumOfTriangleNumber[i]) continue;
            for (int j = 0; j < eurekaArray.length; j++) {
                int sum = i + eurekaArray[j];
                if (sum <= 1000) {
                    isEurekaNumber[sum] = true;
                }
            }
        }
    }

    private static void addEurekaArray(int[] eurekaArray) {
        int index = 0;
        for (int i = 1; ; i++) {
            int eurekaNumber = i * (i + 1) / 2;
            if (eurekaNumber > 1000) {
                break;
            }
            eurekaArray[index++] = eurekaNumber;
        }
    }
}
