package com.example.java.Y2024.M03;

import java.io.*;

public class 일곱난쟁이_2309 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] inputArray = new int[9];
        int[] outPutArray = new int[7];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int input = Integer.parseInt(br.readLine());
            inputArray[i] = input;
            sum += input;
        }

        findNotTwoDwarfs(inputArray, outPutArray, sum);
        insertSort(outPutArray);

        for (int i : outPutArray) {
            bw.write(i + "\n");
        }
        bw.flush();
    }

    private static void findNotTwoDwarfs(int[] inputArray, int[] outPutArray, int sum) {
        int index = 0;
        boolean find = false;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - inputArray[i] - inputArray[j] == 100) {
                    find = true;
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            outPutArray[index] = inputArray[k];
                            index++;
                        }
                    }
                    break;
                }
            }
            if (find) {
                break;
            }
        }
    }

    private static void insertSort(int[] outPutArray) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < i; j++) {
                if (outPutArray[j] > outPutArray[i]) {
                    int current = outPutArray[i];
                    for (int k = i - 1; k >= j; k--) {
                        outPutArray[k + 1] = outPutArray[k];
                    }
                    outPutArray[j] = current;
                }
            }
        }
    }
}
