package com.example.java.august;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 모든 아나그램 찾기
 */
public class all_anagrams_find {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        HashMap<String, Integer> mapA = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < A.length()- B.length() + 1; i++) {
            for (int j = 0; j < B.length(); j++) {
                char AA = A.charAt(i + j);
                Integer number = mapA.get(String.valueOf(AA));
                if (null == number) {
                    mapA.put(String.valueOf(AA), 1);
                    continue;
                }

                mapA.put(String.valueOf(AA), number + 1);
            }

            for (char BB : B.toCharArray()) {
                Integer number = mapA.get(String.valueOf(BB));
                if (null == number) {
                    mapA.clear();
                    break;
                } else {
                    mapA.put(String.valueOf(BB), number - 1);
                }
            }

            if (mapA.size() != 0 && mapA.values().stream().allMatch(one -> one == 0)) {
                answer++;
            }
            mapA.clear();
        }
        System.out.println(answer);
    }
}
