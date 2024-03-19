package com.example.java.Y2024.M03;

import java.util.Scanner;

public class 개미_10158 {
    private void solution() {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int t = scanner.nextInt();
        int x = 1;
        int y = 1;
        int timeX = t % (2 * w);
        for (int i = 0; i < timeX; i++) {
            if(p == w) x = -1;
            else if(p == 0) x = 1;
            p += x;
        }

        int timeY = t % (2 * h);
        for (int j = 0; j < timeY; j++) {
            if(q == h) y = -1;
            else if(q == 0) y = 1;
            q += y;
        }

        System.out.println(p + " " + q);
    }
}
