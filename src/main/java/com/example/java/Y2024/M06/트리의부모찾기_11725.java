package com.example.java.Y2024.M06;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * [BOJ] 11725 - 트리의 부모 찾기
 * https://www.acmicpc.net/problem/11725
 * 알고리즘 : 재귀
 */
public class 트리의부모찾기_11725 {
    static boolean[] check;
    static int[] parents;
    static List<Integer>[] tree;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        check = new boolean[N + 1];
        parents = new int[N + 1];
        tree = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        // 각 노드 기준으로 해당 노드들을 넣기
        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        // 루트 노드인 1번 부터 탐색 시작
        find(1);
        for (int i = 2; i < N + 1; i++) {
            bw.write(parents[i] + "\n");
        }

        bw.flush();
    }

    // nodeNum == 부모 노드
    // 1. 부모 노드에 해당하는 자식 노드 찾기
    // 2. 첫 번째 자식 노드를 찾으면 >> 부모 노드 삽입
    // 3. (재귀) 다음 노드는 부모 기준으로 되어서 자식 노드 찾음
    private void find(int nodeNum) {
        check[nodeNum] = true;
        for (int i = 0; i < tree[nodeNum].size(); i++) {
            int child = tree[nodeNum].get(i);
            if (!check[child]) {
                parents[child] = nodeNum;
                find(child);
            }
        }
    }
}
