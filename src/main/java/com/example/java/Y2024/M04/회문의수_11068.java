package com.example.java.Y2024.M04;

import java.io.*;

public class 회문의수_11068 {
    private void soltion() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] initializeBaseNumbers = new char[64];
        addInitializeBaseNumbers(initializeBaseNumbers);

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            String[] baseNumbers = new String[63];
            int k = 0;
            for (int j = 2; j < 65; j++) {
                int N = input;
                String base = "";
                while (N > 0) {
                    int reminder = N % j;
                    base += initializeBaseNumbers[reminder];
                    N /= j;
                }
                baseNumbers[k] = new StringBuffer(base).reverse().toString();
                k++;
            }

            if (isPalindrome(baseNumbers)) {
                bw.write("1" + "\n");
            } else {
                bw.write("0" + "\n");
            }
        }
        bw.flush();
    }

    private boolean isPalindrome(String[] baseNumbers) {
        for (String str : baseNumbers) {
            boolean isPalindrome = true;
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    isPalindrome = false;
                    break;
                }
                left++;
                right--;
            }
            if (isPalindrome) {
                return true;
            }
        }
        return false;
    }

    private void addInitializeBaseNumbers(char[] initializeBaseNumbers) {
        int index = 0;
        for(char c = '0'; c <= '9' ; c++) initializeBaseNumbers[index++] = c;
        for(char c = 'A'; c <= 'Z'; c++) initializeBaseNumbers[index++] = c;
        for(char c = 'a'; c <= 'z'; c++) initializeBaseNumbers[index++] = c;
        initializeBaseNumbers[index++] = '+';
        initializeBaseNumbers[index++] = '/';
    }
}
